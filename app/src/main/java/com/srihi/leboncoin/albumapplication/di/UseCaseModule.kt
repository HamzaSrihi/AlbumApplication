package com.srihi.leboncoin.albumapplication.di

import com.srihi.leboncoin.domain.usecase.GetAlbumList
import org.koin.dsl.module

val UseCaseModule = module {
    single { GetAlbumList(get()) }
}