package com.mrxx0.rijksmuseum.data.local

import androidx.room.Dao
import androidx.room.Upsert
import androidx.room.Query

@Dao
interface ArtObjectDao {

    @Upsert
    suspend fun upsertAll(artObjects: List<ArtObjectEntity>)

    @Query("DELETE FROM artobjectentity")
    suspend fun clearAll()
}