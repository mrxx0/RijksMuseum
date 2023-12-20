package com.mrxx0.rijksmuseum.data.mappers

import com.mrxx0.rijksmuseum.data.local.ArtObjectEntity
import com.mrxx0.rijksmuseum.data.remote.ArtObjectDto
import com.mrxx0.rijksmuseum.domain.ArtObject

fun ArtObjectDto.toArtObjectEntity() : ArtObjectEntity {
    return ArtObjectEntity(
        principalOrFirstMaker = principalOrFirstMaker,
        webImageOffsetPercentageX = webImage?.offsetPercentageX,
        webImageOffsetPercentageY = webImage?.offsetPercentageY,
        webImageWidth = webImage?.width,
        webImageGuid = webImage?.guid,
        webImageUrl = webImage?.url,
        webImageHeight = webImage?.height,
        headerImageOffsetPercentageX = headerImage?.offsetPercentageX,
        headerImageOffsetPercentageY = headerImage?.offsetPercentageY,
        headerImageWidth = headerImage?.width,
        headerImageGuid = headerImage?.guid,
        headerImageUrl = headerImage?.url,
        headerImageHeight = headerImage?.height,
        objectNumber = objectNumber,
        linkWeb = links?.web,
        linkSelf = links?.self,
        hasImage = hasImage,
        showImage = showImage,
        id = id,
        title = title,
        longTitle = longTitle,
        permitDownload = permitDownload
    )
}

fun ArtObjectEntity.toArtObject() : ArtObject {
    return ArtObject(
        principalOrFirstMaker = principalOrFirstMaker,
        webImageOffsetPercentageX = webImageOffsetPercentageX,
        webImageOffsetPercentageY = webImageOffsetPercentageY,
        webImageWidth = webImageWidth,
        webImageGuid = webImageGuid,
        webImageUrl = webImageUrl,
        webImageHeight = webImageHeight,
        headerImageOffsetPercentageX = headerImageOffsetPercentageX,
        headerImageOffsetPercentageY = headerImageOffsetPercentageY,
        headerImageWidth = headerImageWidth,
        headerImageGuid = headerImageGuid,
        headerImageUrl = headerImageUrl,
        headerImageHeight = headerImageHeight,
        objectNumber = objectNumber,
        linkWeb = linkWeb,
        linkSelf = linkSelf,
        hasImage = hasImage,
        showImage = showImage,
        id = id,
        title = title,
        longTitle = longTitle,
        permitDownload = permitDownload
    )
}