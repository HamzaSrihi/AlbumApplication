package com.srihi.leboncoin.albumapplication.di

import com.srihi.leboncoin.data.db.repository.AlbumRepository
import com.srihi.leboncoin.domain.usecase.GetAlbumListRepository
import org.koin.dsl.module

val GatewayModule = module {
    single { AlbumRepository(get(), get()) as GetAlbumListRepository }
}