package com.mrxx0.rijksmuseum.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.mrxx0.rijksmuseum.data.local.ArtObjectEntity
import com.mrxx0.rijksmuseum.data.mappers.toArtObject
import com.mrxx0.rijksmuseum.data.remote.ApiService
import com.mrxx0.rijksmuseum.data.remote.ArtObjectItemDtoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ArtObjectViewModel @Inject constructor(
    pager: Pager<Int, ArtObjectEntity>,
    private val apiService: ApiService
): ViewModel(){

    private val _result = MutableLiveData<ArtObjectItemDtoResponse?>()
    val result: MutableLiveData<ArtObjectItemDtoResponse?> get() = _result

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    val artObjectPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toArtObject() }
        }
        .cachedIn(viewModelScope)

    fun fetchItemDetails(itemId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = apiService.getItem(itemId, ApiService.API_KEY)
                _result.value = response
                _isLoading.value = false
            } catch (e: HttpException) {
                _result.value = null
                _isLoading.value = false
                e.printStackTrace()
            } catch (e: IOException) {
                _result.value = null
                _isLoading.value = false
                e.printStackTrace()
            }
        }
    }
}