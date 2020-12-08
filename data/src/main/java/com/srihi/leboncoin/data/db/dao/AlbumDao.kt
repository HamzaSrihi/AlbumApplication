package com.srihi.leboncoin.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.srihi.leboncoin.data.db.entities.ALBUM_TABLE
import com.srihi.leboncoin.data.db.entities.AlbumEntity
import io.reactivex.Observable

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbums(albums : List<AlbumEntity>)

    @Query("SELECT * FROM $ALBUM_TABLE")
    fun getAlbums(): Observable<List<AlbumEntity>>
}