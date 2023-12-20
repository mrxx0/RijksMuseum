package com.mrxx0.rijksmuseum.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mrxx0.rijksmuseum.data.local.ArtObjectDatabase
import com.mrxx0.rijksmuseum.data.local.ArtObjectEntity
import com.mrxx0.rijksmuseum.data.remote.ApiService
import com.mrxx0.rijksmuseum.data.remote.ArtObjectRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideArtObjectDatabase(@ApplicationContext context: Context): ArtObjectDatabase {
        return Room.databaseBuilder(
            context,
            ArtObjectDatabase::class.java,
            "artobjects.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                    coerceInputValues = true
                }.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideArtObjectPager(
        artObjectDatabase: ArtObjectDatabase,
        artObjectApiService: ApiService,
    ): Pager<Int, ArtObjectEntity> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = ArtObjectRemoteMediator(
                artObjectDatabase = artObjectDatabase,
                artObjectApiService = artObjectApiService
            ),
            pagingSourceFactory = {
                artObjectDatabase.dao.pagingSource()
            }
        )
    }
}