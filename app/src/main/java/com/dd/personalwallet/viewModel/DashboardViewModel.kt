package com.dd.personalwallet.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dd.personalwallet_core.data.WeatherData
import com.dd.personalwallet_core.domain.usecase.IDashBoardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var homeUseCase: IDashBoardUseCase

    val responseData = MutableLiveData<WeatherData>()

    val isButtonVisibility = ObservableField<Boolean>()

    fun getRemoteDate() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
               homeUseCase.getDataRemote(10.838741, 106.802248,"710cdcfa5ef43deff6842b2eb49a147e").onSuccess {
                   responseData.postValue(it)
               }
            }
        }
    }
}