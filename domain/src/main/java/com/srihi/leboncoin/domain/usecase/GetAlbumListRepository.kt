package com.srihi.leboncoin.domain.usecase

import com.srihi.leboncoin.domain.model.Album
import io.reactivex.Observable

interface GetAlbumListRepository {

    fun getAlbums(): Observable<List<Album>>
}
