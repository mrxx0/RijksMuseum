package com.mrxx0.rijksmuseum.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtObjectsDtoResponse(
    var artObjects: List<ArtObjectDto>
)

@Serializable
data class ArtObjectDto(
    @SerialName(value = "principalOrFirstMaker")
    val principalOrFirstMaker: String = "",
    @SerialName(value = "webImage")
    val webImage: WebImageDto? = null,
    @SerialName(value = "headerImage")
    val headerImage: HeaderImageDto? = null,
    @SerialName(value = "objectNumber")
    val objectNumber: String = "",
    @SerialName(value = "links")
    val links: LinksDto? = null,
    @SerialName(value = "hasImage")
    val hasImage: Boolean = false,
    @SerialName(value = "showImage")
    val showImage: Boolean = false,
    @SerialName(value = "id")
    val id: String = "",
    @SerialName(value = "title")
    val title: String = "",
    @SerialName(value = "longTitle")
    val longTitle: String = "",
    @SerialName(value = "permitDownload")
    val permitDownload: Boolean = false
)

@Serializable
data class WebImageDto(
    @SerialName(value = "offsetPercentageY")
    val offsetPercentageY: Int = 0,
    @SerialName(value = "offsetPercentageX")
    val offsetPercentageX: Int = 0,
    @SerialName(value = "width")
    val width: Int = 0,
    @SerialName(value = "guid")
    val guid: String = "",
    @SerialName(value = "url")
    val url: String = "",
    @SerialName(value = "height")
    val height: Int = 0
)

@Serializable
data class LinksDto(
    @SerialName(value = "web")
    val web: String = "",
    @SerialName(value = "self")
    val self: String = ""
)

@Serializable
data class HeaderImageDto(
    @SerialName(value = "offsetPercentageY")
    val offsetPercentageY: Int = 0,
    @SerialName(value = "offsetPercentageX")
    val offsetPercentageX: Int = 0,
    @SerialName(value = "width")
    val width: Int = 0,
    @SerialName(value = "guid")
    val guid: String = "",
    @SerialName(value = "url")
    val url: String = "",
    @SerialName(value = "height")
    val height: Int = 0
)

