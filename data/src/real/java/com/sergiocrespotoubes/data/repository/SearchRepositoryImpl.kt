package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasource
import com.sergiocrespotoubes.data.db.datasource.TracksDbDataSource
import com.sergiocrespotoubes.data.mapper.toArtistEntity
import com.sergiocrespotoubes.data.mapper.toTrackEntity
import com.sergiocrespotoubes.data.mapper.toTrackModel
import com.sergiocrespotoubes.data.network.datasource.SearchNetworkDataSource
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl
    @Inject
    constructor(
        private val artistsDbDatasource: ArtistsDbDatasource,
        private val tracksDbDatasource: TracksDbDataSource,
        private val searchNetworkDataSource: SearchNetworkDataSource,
    ) : SearchRepository {
        override suspend fun getSearchByArtist(artistName: String): Flow<Result<List<ArtistModel>>> =
            flow {
                merge(
                    readArtistsFromDb(),
                    readArtistsFromNetwork(artistName),
                ).collect { result ->
                    emit(result)
                }
            }

        private fun readArtistsFromNetwork(artistName: String) =
            flow {
                searchNetworkDataSource.getSearchArtists(artistName)
                    .map { searchDto ->
                        searchDto.artists?.items?.map { artistDto ->
                            artistDto.toArtistEntity()
                        }
                    }.map { artistsEntity ->
                        artistsEntity?.let {
                            artistsDbDatasource.clearAll()
                            artistsDbDatasource.saveArtists(artistsEntity)
                        }
                        emitAll(readArtistsFromDb())
                    }
            }.flowOn(Dispatchers.IO)

        private fun readArtistsFromDb() =
            flow {
                val artistsFlow =
                    artistsDbDatasource.getArtists().map {
                        Result.success(
                            it.map { artistsEntity ->
                                artistsEntity.toTrackModel()
                            },
                        )
                    }
                emitAll(artistsFlow)
            }.flowOn(Dispatchers.IO)

        override suspend fun getSearchByTrack(trackName: String): Flow<Result<List<TrackModel>>> =
            flow {
                merge(
                    readTracksFromDb(),
                    readTracksFromNetwork(trackName),
                ).collect { result ->
                    emit(result)
                }
            }

        private fun readTracksFromNetwork(tracksName: String) =
            flow {
                searchNetworkDataSource.getSearchTracks(tracksName)
                    .map { searchDto ->
                        searchDto.tracks?.items?.map { trackDto ->
                            trackDto.toTrackEntity()
                        }
                    }.map { tracksEntity ->
                        tracksEntity?.let {
                            tracksDbDatasource.clearAll()
                            tracksDbDatasource.saveTracks(tracksEntity)
                        }
                        emitAll(readTracksFromDb())
                    }
            }.flowOn(Dispatchers.IO)

        private fun readTracksFromDb() =
            flow {
                val tracksFlow =
                    tracksDbDatasource.getTracks().map {
                        Result.success(
                            it.map { tracksEntity ->
                                tracksEntity.toTrackModel()
                            },
                        )
                    }
                emitAll(tracksFlow)
            }.flowOn(Dispatchers.IO)
    }
