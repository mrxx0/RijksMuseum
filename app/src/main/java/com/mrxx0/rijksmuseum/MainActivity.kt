package com.mrxx0.rijksmuseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.mrxx0.rijksmuseum.presentation.artobject.ArtObjectScreen
import com.mrxx0.rijksmuseum.presentation.artobject.ArtObjectViewModel
import com.mrxx0.rijksmuseum.presentation.itemdetails.ItemDetailsScreen
import com.mrxx0.rijksmuseum.presentation.itemdetails.ItemDetailsViewModel
import com.mrxx0.rijksmuseum.ui.theme.RijksMuseumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RijksMuseumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val artObjectViewModel = hiltViewModel<ArtObjectViewModel>()
                    val itemDetailsViewModel = hiltViewModel<ItemDetailsViewModel>()
                    val artObjects =
                        artObjectViewModel.artObjectPagingFlow.collectAsLazyPagingItems()
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "ArtObjectScreen") {
                        composable(route = "ArtObjectScreen") {
                            ArtObjectScreen(
                                artObjects = artObjects,
                                navController = navController,
                                itemDetailsViewModel
                            )
                        }
                        composable(route = "ItemDetailsScreen") {
                            ItemDetailsScreen(itemDetailsViewModel)
                        }
                    }
                }
            }
        }
    }
}