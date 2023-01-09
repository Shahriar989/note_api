package com.shahriar.a09_note_api_class_28__28_2.di

import com.shahriar.a09_note_api_class_28__28_2.api.UserApi
import com.shahriar.a09_note_api_class_28__28_2.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit.Builder{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
    }

    @Provides
    @Singleton
    fun providesUserApi(retrofit: Retrofit.Builder): UserApi{

        return retrofit.build().create(UserApi::class.java)
    }
}