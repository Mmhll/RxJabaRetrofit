package com.mhl.rxjaba.di

import android.content.Context
import com.mhl.rxjaba.R
import com.mhl.rxjaba.model.ImdbRepository
import com.mhl.rxjaba.model.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Named("baseUrl")
    fun providesBaseUrl() : String = "https://imdb-api.com/ru/API/"

    @Provides
    @Singleton
    fun providesRetrofit(@Named("baseUrl") url : String) : Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit) : MainService = retrofit.create(MainService::class.java)

    @Provides
    @Singleton
    fun providesRepository(service: MainService, @ApplicationContext context: Context) :ImdbRepository =
        ImdbRepository(service, context.getString(R.string.api_key))
}