package com.mrxx0.rijksmuseum.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mrxx0.rijksmuseum.domain.ArtObject
import kotlinx.coroutines.launch

@Composable
fun ArtObjectCard(
    artObject: ArtObject,
    onItemClick: (String) -> Unit,
    navController: NavController,
    viewModel: ArtObjectViewModel = hiltViewModel()
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .height(IntrinsicSize.Max)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

        Row(
            Modifier
                .background(MaterialTheme.colorScheme.primary),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = artObject.webImageUrl,
                contentDescription = artObject.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(96.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "${artObject.title}",
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(20.dp))
                FilledTonalButton(
                    colors = ButtonDefaults.filledTonalButtonColors(),
                    onClick = {
                    viewModel.viewModelScope.launch {
                        onItemClick(artObject.objectNumber)
                        navController.navigate("ItemDetailsScreen")
                    }
                }) {
                    Text(
                        text = "View Details",
                        style = typography.bodyMedium,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }

            }
        }
    }
}