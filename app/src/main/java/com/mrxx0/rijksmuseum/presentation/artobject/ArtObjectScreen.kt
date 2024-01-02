package com.mrxx0.rijksmuseum.presentation.artobject

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.mrxx0.rijksmuseum.domain.ArtObject
import com.mrxx0.rijksmuseum.presentation.itemdetails.ItemDetailsViewModel

@Composable
fun ArtObjectScreen(
    artObjects: LazyPagingItems<ArtObject>,
    navController: NavController,
    itemDetailsViewModel: ItemDetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = artObjects.loadState) {
        if (artObjects.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: ${(artObjects.loadState.refresh as LoadState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (artObjects.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(count = artObjects.itemCount) { index ->
                    val artObjectItem = artObjects[index]
                    if (artObjectItem != null) {
                        ArtObjectCard(
                            artObject = artObjectItem, onItemClick = { itemId ->
                                itemDetailsViewModel.fetchItemDetails(itemId)
                            },
                            navController = navController
                        )
                    }
                }
                item {
                    if (artObjects.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }

    }
}