package com.mrxx0.rijksmuseum.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtObjectItemDtoResponse(
    @SerialName(value = "artObjectPage")
    val artObjectPage: ArtObjectPage,
    @SerialName(value = "artObject")
    val artObject: ArtObject,
    @SerialName(value = "elapsedMilliseconds")
    val elapsedMilliseconds: Int = 0
)

@Serializable
data class ArtObjectPage(
    @SerialName(value = "audioFileLabel2")
    val audioFileLabel2: String? = null,
    @SerialName(value = "adlibOverrides")
    val adlibOverrides: AdlibOverrides,
    @SerialName(value = "objectNumber")
    val objectNumber: String? = null,
    @SerialName(value = "audioFileLabel1")
    val audioFileLabel1: String? = null,
    @SerialName(value = "id")
    val id: String? = null,
    @SerialName(value = "plaqueDescription")
    val plaqueDescription: String? = null,
    @SerialName(value = "audioFile1")
    val audioFile1: String? = null,
    @SerialName(value = "updatedOn")
    val updatedOn: String? = null,
    @SerialName(value = "lang")
    val lang: String? = null,
    @SerialName(value = "createdOn")
    val createdOn: String? = null
)

@Serializable
data class PrincipalMakersItem(
    @SerialName(value = "placeOfBirth")
    val placeOfBirth: String? = null,
    @SerialName(value = "occupation")
    val occupation: List<String>?,
    @SerialName(value = "dateOfDeath")
    val dateOfDeath: String? = null,
    @SerialName(value = "roles")
    val roles: List<String>?,
    @SerialName(value = "productionPlaces")
    val productionPlaces: List<String>?,
    @SerialName(value = "dateOfBirth")
    val dateOfBirth: String? = null,
    @SerialName(value = "placeOfDeath")
    val placeOfDeath: String? = null,
    @SerialName(value = "biography")
    val biography: String? = null,
    @SerialName(value = "dateOfDeathPrecision")
    val dateOfDeathPrecision: String? = null,
    @SerialName(value = "qualification")
    val qualification: String? = null,
    @SerialName(value = "nationality")
    val nationality: String? = null,
    @SerialName(value = "unFixedName")
    val unFixedName: String? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "labelDesc")
    val labelDesc: String? = null,
    @SerialName(value = "dateOfBirthPrecision")
    val dateOfBirthPrecision: String? = null
)

@Serializable
data class Classification(
    @SerialName(value = "iconClassIdentifier")
    val iconClassIdentifier: List<String>?,
    @SerialName(value = "objectNumbers")
    val objectNumbers: List<String>?,
    @SerialName(value = "iconClassDescription")
    val iconClassDescription: List<String>?
)

@Serializable
data class Label(
    @SerialName(value = "date")
    val date: String? = null,
    @SerialName(value = "notes")
    val notes: String? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "title")
    val title: String? = null,
    @SerialName(value = "makerLine")
    val makerLine: String? = null
)

@Serializable
data class Links(
    @SerialName(value = "search")
    val search: String? = null
)

@Serializable
data class AdlibOverrides(
    @SerialName(value = "titel")
    val titel: String? = null,
    @SerialName(value = "etiketText")
    val etiketText: String? = null,
    @SerialName(value = "maker")
    val maker: String? = null
)

@Serializable
data class ArtObject(
    @SerialName(value = "labelText")
    val labelText: String? = null,
    @SerialName(value = "language")
    val language: String? = null,
    @SerialName(value = "showImage")
    val showImage: Boolean = false,
    @SerialName(value = "physicalMedium")
    val physicalMedium: String? = null,
    @SerialName(value = "webImage")
    val webImage: WebImage? = null,
    @SerialName(value = "subTitle")
    val subTitle: String? = null,
    @SerialName(value = "copyrightHolder")
    val copyrightHolder: String? = null,
    @SerialName(value = "plaqueDescriptionEnglish")
    val plaqueDescriptionEnglish: String? = null,
    @SerialName(value = "links")
    val links: Links? = null,
    @SerialName(value = "priref")
    val priref: String? = null,
    @SerialName(value = "id")
    val id: String? = null,
    @SerialName(value = "documentation")
    val documentation: List<String>?,
    @SerialName(value = "plaqueDescriptionDutch")
    val plaqueDescriptionDutch: String? = null,
    @SerialName(value = "classification")
    val classification: Classification,
    @SerialName(value = "materials")
    val materials: List<String>?,
    @SerialName(value = "techniques")
    val techniques: List<String>?,
    @SerialName(value = "longTitle")
    val longTitle: String? = null,
    @SerialName(value = "scLabelLine")
    val scLabelLine: String? = null,
    @SerialName(value = "principalOrFirstMaker")
    val principalOrFirstMaker: String? = null,
    @SerialName(value = "principalMaker")
    val principalMaker: String? = null,
    @SerialName(value = "objectNumber")
    val objectNumber: String? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "principalMakers")
    val principalMakers: List<PrincipalMakersItem>?,
    @SerialName(value = "hasImage")
    val hasImage: Boolean = false,
    @SerialName(value = "title")
    val title: String? = null,
    @SerialName(value = "artistRole")
    val artistRole: String? = null,
    @SerialName(value = "dating")
    val dating: Dating? = null,
    @SerialName(value = "acquisition")
    val acquisition: Acquisition? = null,
    @SerialName(value = "productionPlaces")
    val productionPlaces: List<String>?,
    @SerialName(value = "label")
    val label: Label? = null,
    @SerialName(value = "location")
    val location: String? = null,
    @SerialName(value = "dimensions")
    val dimensions: List<DimensionsItem>?
)

@Serializable
data class Dating(
    @SerialName(value = "period")
    val period: Int = 0,
    @SerialName(value = "sortingDate")
    val sortingDate: Int = 0,
    @SerialName(value = "yearLate")
    val yearLate: Int = 0,
    @SerialName(value = "yearEarly")
    val yearEarly: Int = 0,
    @SerialName(value = "presentingDate")
    val presentingDate: String? = null
)

@Serializable

data class Acquisition(
    @SerialName(value = "date")
    val date: String? = null,
    @SerialName(value = "method")
    val method: String? = null,
    @SerialName(value = "creditLine")
    val creditLine: String? = null
)

@Serializable
data class WebImage(
    @SerialName(value = "offsetPercentageY")
    val offsetPercentageY: Int = 0,
    @SerialName(value = "offsetPercentageX")
    val offsetPercentageX: Int = 0,
    @SerialName(value = "width")
    val width: Int = 0,
    @SerialName(value = "guid")
    val guid: String? = null,
    @SerialName(value = "url")
    val url: String? = null,
    @SerialName(value = "height")
    val height: Int = 0
)

@Serializable
data class DimensionsItem(
    @SerialName(value = "unit")
    val unit: String? = null,
    @SerialName(value = "precision")
    val precision: String? = null,
    @SerialName(value = "part")
    val part: String? = null,
    @SerialName(value = "type")
    val type: String? = null,
    @SerialName(value = "value")
    val value: String? = null
)