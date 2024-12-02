package com.dd.personalwallet.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dd.personalwallet.data.CareEmployee
import com.dd.personalwallet.data.ShoppingBanner
import com.dd.personalwallet_core.data.WeatherData
import com.dd.personalwallet.domain.useCase.IHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var homeUseCase: IHomeUseCase

    val responseData = MutableLiveData<WeatherData>()

    private var _careEmployee = MutableLiveData<List<CareEmployee>>()
    val careEmployee: LiveData<List<CareEmployee>> = _careEmployee

    private var _bannerShopping = MutableLiveData<List<ShoppingBanner>>()
    val bannerShopping: LiveData<List<ShoppingBanner>> = _bannerShopping

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

    fun getCareEmployeeList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                homeUseCase.getCareEmployees().onSuccess {
                    _careEmployee.postValue(it)
                }
            }
        }
    }

    fun getBannerList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                homeUseCase.getBannerList().onSuccess {
                    _bannerShopping.postValue(it)
                }
            }
        }
    }
}
