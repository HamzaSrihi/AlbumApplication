package com.srihi.leboncoin.albumapplication.di

import androidx.room.Room
import com.srihi.leboncoin.data.db.AlbumDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val LocalDataModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AlbumDatabase::class.java, "album_database.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AlbumDatabase>().albumDao() }
}