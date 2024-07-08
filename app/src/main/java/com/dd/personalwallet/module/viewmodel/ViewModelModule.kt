package com.dd.personalwallet.module.viewmodel

import androidx.lifecycle.ViewModel
import com.dd.personalwallet.viewModel.DashboardViewModel
import com.dd.personalwallet.viewModel.HomeViewModel
import com.dd.personalwallet.viewModel.MainViewModel
import com.dd.personalwallet.viewModel.TransactionsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun getHomeViewModel(): ViewModel {
        return HomeViewModel()
    }

    @Provides
    fun getMainViewModel(): ViewModel {
        return MainViewModel()
    }

    @Provides
    fun getDashboardViewModel(): ViewModel {
        return DashboardViewModel()
    }

    @Provides
    fun getTransactionsViewModel(): ViewModel {
        return TransactionsViewModel()
    }
}
