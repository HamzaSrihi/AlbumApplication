package com.srihi.leboncoin.data.db.repository

import android.util.Log
import com.srihi.leboncoin.data.api.ApiServices
import com.srihi.leboncoin.data.db.dao.AlbumDao
import com.srihi.leboncoin.data.db.mapDataToEntities
import com.srihi.leboncoin.data.db.mapEntitiesToData
import com.srihi.leboncoin.domain.model.Album
import com.srihi.leboncoin.domain.usecase.GetAlbumListRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 *
 * @param ApiServices
 * @param AlbumDao
 *
 */
class AlbumRepository(private val apiService: ApiServices, private val albumDao: AlbumDao) :
    GetAlbumListRepository {

    override fun getAlbums(): Observable<List<Album>> {
        return apiService.getAlbumList().onErrorResumeNext(loadAlbums())
            .doOnNext {
                storeAlbums(it)
            }.doOnComplete {
                loadAlbums()
            }

    }

    private fun storeAlbums(albums: List<Album>) =
        Observable.fromCallable { albumDao.insertAlbums(albums = mapDataToEntities(albums)) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                Log.d("AlbumRepository", "Inserted ${albums.size} albums from API in DB")
            }

    private fun loadAlbums() = albumDao.getAlbums().map { mapEntitiesToData(it) }

}