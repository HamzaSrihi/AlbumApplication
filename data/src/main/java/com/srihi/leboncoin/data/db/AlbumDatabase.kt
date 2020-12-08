package com.srihi.leboncoin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srihi.leboncoin.data.db.dao.AlbumDao
import com.srihi.leboncoin.data.db.entities.AlbumEntity

const val DATABASE_VERSION = 1

@Database(entities = [AlbumEntity::class], version = DATABASE_VERSION)
abstract class AlbumDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}