package com.mrxx0.rijksmuseum.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ArtObjectEntity::class],
    version = 1
)
abstract class ArtObjectDatabase : RoomDatabase() {
    abstract val dao: ArtObjectDao
}