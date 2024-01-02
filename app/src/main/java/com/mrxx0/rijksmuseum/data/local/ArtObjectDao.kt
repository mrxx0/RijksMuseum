package com.mrxx0.rijksmuseum.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ArtObjectDao {

    @Upsert
    suspend fun upsertAll(artObjects: List<ArtObjectEntity>)

    @Query("DELETE FROM artobjectentity")
    suspend fun clearAll()

    @Query("SELECT * FROM artobjectentity")
    fun pagingSource(): PagingSource<Int, ArtObjectEntity>

}