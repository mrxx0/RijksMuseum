package com.mrxx0.rijksmuseum.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.mrxx0.rijksmuseum.data.local.ArtObjectDatabase
import com.mrxx0.rijksmuseum.data.local.ArtObjectEntity
import com.mrxx0.rijksmuseum.data.mappers.toArtObjectEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class ArtObjectRemoteMediator(
    private val artObjectDatabase: ArtObjectDatabase,
    private val artObjectApiService: ApiService
) : RemoteMediator<Int, ArtObjectEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ArtObjectEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.idStorage / state.config.pageSize) + 1
                    }
                }
            }
            val artCollection = artObjectApiService.getCollection(
                key = ApiService.API_KEY,
                p = loadKey.toInt(),
                ps = state.config.pageSize
            )
            artObjectDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    artObjectDatabase.dao.clearAll()
                }
                val artObjectEntities = artCollection.artObjects.map { it.toArtObjectEntity() }
                artObjectDatabase.dao.upsertAll(artObjectEntities)
            }
            MediatorResult.Success(
                endOfPaginationReached = artCollection.artObjects.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}