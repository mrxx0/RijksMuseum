package com.mrxx0.rijksmuseum.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtObjectEntity(
    @PrimaryKey(autoGenerate = true)
    val idStorage: Long = 0,
    val principalOrFirstMaker: String = "",
    val webImageOffsetPercentageY: Int? = 0,
    val webImageOffsetPercentageX: Int? = 0,
    val webImageWidth: Int? = 0,
    val webImageGuid: String? = "",
    val webImageUrl: String? = "",
    val webImageHeight: Int? = 0,
    val headerImageOffsetPercentageY: Int? = 0,
    val headerImageOffsetPercentageX: Int? = 0,
    val headerImageWidth: Int? = 0,
    val headerImageGuid: String? = "",
    val headerImageUrl: String? = "",
    val headerImageHeight: Int? = 0,
    val objectNumber: String = "",
    val linkWeb: String? = "",
    val linkSelf: String? = "",
    val hasImage: Boolean = false,
    val showImage: Boolean = false,
    val id: String = "",
    val title: String = "",
    val longTitle: String = "",
    val permitDownload: Boolean = false,
)

