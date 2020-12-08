package com.srihi.leboncoin.domain.usecase

import com.srihi.leboncoin.domain.model.Album
import io.reactivex.Observable

class GetAlbumList(private val getAlbumListRepository: GetAlbumListRepository) {
    fun execute(): Observable<List<Album>> = getAlbumListRepository.getAlbums()
}