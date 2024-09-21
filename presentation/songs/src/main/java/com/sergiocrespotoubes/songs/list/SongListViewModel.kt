package com.sergiocrespotoubes.songs.list

import com.sergiocrespotoubes.domain.usecase.songs.GetSongsListUseCase

class SongListViewModel(
    private val getSongsListUseCase: GetSongsListUseCase
) {
    init {
        getSongsListUseCase.execute()
    }
}