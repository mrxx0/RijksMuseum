package com.mrxx0.rijksmuseum.presentation.itemdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrxx0.rijksmuseum.data.remote.ApiService
import com.mrxx0.rijksmuseum.data.remote.ArtObjectItemDtoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _result = MutableLiveData<ArtObjectItemDtoResponse?>()
    val result: MutableLiveData<ArtObjectItemDtoResponse?> get() = _result

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun fetchItemDetails(itemId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response = apiService.getItem(itemId, ApiService.API_KEY)
                _result.postValue(response)
                _isLoading.postValue(false)
            } catch (e: HttpException) {
                _result.postValue(null)
                _isLoading.postValue(false)
                e.printStackTrace()
            } catch (e: IOException) {
                _result.postValue(null)
                _isLoading.postValue(false)
                e.printStackTrace()
            }
        }
    }
}