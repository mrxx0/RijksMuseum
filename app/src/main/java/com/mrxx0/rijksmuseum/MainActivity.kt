package com.mrxx0.rijksmuseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.mrxx0.rijksmuseum.presentation.ArtObjectScreen
import com.mrxx0.rijksmuseum.presentation.ArtObjectViewModel
import com.mrxx0.rijksmuseum.presentation.ItemDetailsScreen
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
                    val viewModel = hiltViewModel<ArtObjectViewModel>()
                    val artObjects = viewModel.artObjectPagingFlow.collectAsLazyPagingItems()
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "ArtObjectScreen") {
                        composable(route = "ArtObjectScreen") {
                            ArtObjectScreen(
                                artObjects = artObjects,
                                navController = navController,
                                viewModel
                            )
                        }
                        composable(route = "ItemDetailsScreen") {
                            ItemDetailsScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}