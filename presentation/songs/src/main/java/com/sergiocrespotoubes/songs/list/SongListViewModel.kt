package com.sergiocrespotoubes.songs.list

class SongListViewModel(
    private val getSongsListUseCase: GetSongsListUseCase
) {
    init {
        getSongsListUseCase.execute()
    }
}