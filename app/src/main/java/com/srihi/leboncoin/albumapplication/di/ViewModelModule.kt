package com.srihi.leboncoin.albumapplication.di

import com.srihi.leboncoin.albumapplication.ui.albumList.AlbumListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { AlbumListViewModel(get()) }
}