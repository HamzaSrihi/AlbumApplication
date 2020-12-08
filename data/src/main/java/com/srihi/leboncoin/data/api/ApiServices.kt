package com.srihi.leboncoin.data.api

import com.srihi.leboncoin.domain.model.Album
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Api Services
 */
interface ApiServices {
    @GET("technical-test.json")
    fun getAlbumList(): Observable<List<Album>>
}