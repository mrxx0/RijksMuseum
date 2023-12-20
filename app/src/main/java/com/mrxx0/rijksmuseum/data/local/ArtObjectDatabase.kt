package com.mrxx0.rijksmuseum.data.local

import androidx.room.Database

@Database(
    entities = [ArtObjectEntity::class],
    version = 1
)
abstract class ArtObjectDatabase {
    abstract val dao: ArtObjectDao
}