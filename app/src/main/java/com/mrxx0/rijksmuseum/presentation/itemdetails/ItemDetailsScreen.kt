package com.mrxx0.rijksmuseum.presentation.itemdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.mrxx0.rijksmuseum.data.remote.Acquisition
import com.mrxx0.rijksmuseum.data.remote.PrincipalMakersItem

@Composable
fun ItemDetailsScreen(
    itemDetailsViewModel: ItemDetailsViewModel = hiltViewModel()
) {
    val itemDetails by itemDetailsViewModel.result.observeAsState()
    val isLoading by itemDetailsViewModel.isLoading.observeAsState()
    val scroll = rememberScrollState()

    Box(
        Modifier
            .fillMaxSize()
    ) {
        if (isLoading != false) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scroll),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scroll),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemDetails?.let { details ->
                    details.artObject.title?.let { ItemTitle(itemTitle = it) }
                    if (details.artObject.showImage) {
                        details.artObject.webImage?.let {
                            it.url?.let { it1 ->
                                ItemImage(itemImageUrl = it1)
                            }
                        }
                    }
                    details.artObject.plaqueDescriptionEnglish?.let {
                        ItemDescription(itemDescription = it)
                    }
                    details.artObject.principalMakers?.let {
                        ItemMakers(itemMakers = it)
                    }
                    details.artObject.acquisition?.let {
                        ItemAcquisition(itemAcquisition = it)
                    }
                } ?: run {
                    Text(
                        text = "Network error: Please check you connexion and try again.",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemDescription(
    itemDescription: String
) {
    Card(
        Modifier.padding(15.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Description",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = itemDescription,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}

@Composable
fun ItemAcquisition(
    itemAcquisition: Acquisition
) {
    Card(
        Modifier.padding(15.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Acquisition",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
            ) {
                itemAcquisition.method.let { method ->
                    Text(
                        text = "Method: $method",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
                itemAcquisition.date.let { date ->
                    Text(
                        text = "Date: $date",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
                if (itemAcquisition.creditLine != null) {
                    Text(
                        text = "Credit line: ${itemAcquisition.creditLine}",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemTitle(
    itemTitle: String
) {
    Text(
        text = itemTitle,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    )
}

@Composable
fun ItemImage(
    itemImageUrl: String
) {
    AsyncImage(
        model = itemImageUrl,
        contentDescription = "Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Composable
fun ItemMakers(
    itemMakers: List<PrincipalMakersItem>
) {
    Card(
        Modifier.padding(15.dp)
    ) {
        itemMakers.forEach {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.Center
            ) {
                it.name?.let { it1 ->
                    Text(
                        text = it1,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                            .align(alignment = Alignment.CenterVertically)
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Column {
                    it.nationality?.let { it1 ->
                        Text(
                            text = "Nationality: $it1",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                    it.placeOfBirth?.let { it1 ->
                        Text(
                            text = "Place of birth: $it1",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                    it.placeOfDeath?.let { it1 ->
                        Text(
                            text = "Place of death: $it1",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                    it.occupation?.let { it1 ->
                        if (it1.isNotEmpty()) {
                            Text(
                                text = "Occupation: ${it1[0]}",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier
                                    .padding(5.dp)
                            )
                        }
                    }
                    it.productionPlaces?.let { it1 ->
                        if (it1.isNotEmpty()) {
                            Row {
                                Text(
                                    text = "Production places:",
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier
                                        .padding(top = 5.dp, start = 5.dp, bottom = 5.dp)
                                )
                                it1.forEach { place ->
                                    Text(
                                        text = place,
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onBackground,
                                        modifier = Modifier
                                            .padding(top = 5.dp, start = 5.dp, bottom = 5.dp)
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
