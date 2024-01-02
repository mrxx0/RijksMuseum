package com.mrxx0.rijksmuseum.presentation.artobject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.mrxx0.rijksmuseum.data.local.ArtObjectEntity
import com.mrxx0.rijksmuseum.data.mappers.toArtObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ArtObjectViewModel @Inject constructor(
    pager: Pager<Int, ArtObjectEntity>,
) : ViewModel() {

    val artObjectPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toArtObject() }
        }
        .cachedIn(viewModelScope)
}