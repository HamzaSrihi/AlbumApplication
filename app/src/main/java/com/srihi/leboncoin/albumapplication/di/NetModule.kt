package com.srihi.leboncoin.albumapplication.di

import com.srihi.leboncoin.albumapplication.BuildConfig
import com.srihi.leboncoin.data.api.ApiServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val NetModule = module {

    single { provideInterceptLogging() }

    single { provideOkHttpClient(get()) }

    single { provideRetrofitClient(get()) }

    single { provideAlbumWs(get()) }
}

fun provideInterceptLogging(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}

fun provideOkHttpClient(loginInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(loginInterceptor)
        .build()


fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.SERVICE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()


fun provideAlbumWs(retrofit: Retrofit): ApiServices =
    retrofit.create(ApiServices::class.java)