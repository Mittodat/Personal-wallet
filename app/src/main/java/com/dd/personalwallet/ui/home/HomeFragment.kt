package com.dd.personalwallet.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dd.personalwallet.R
import com.dd.personalwallet.databinding.FragmentHomeBinding
import com.dd.personalwallet.utils.DateTimeUtils
import com.dd.personalwallet.viewModel.DashboardViewModel
import com.dd.personalwallet.viewModel.HomeViewModel
import com.dd.personalwallet_core.fragment.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var tabLayoutModels = listOf<Fragment>()

    @SuppressLint("DefaultLocale")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = homeViewModel
        val now = DateTimeUtils.getCurrentDate()
        val day = String.format("%02d", now[0])
        val month = String.format("%02d", now[1])
        val year = now[2]

        homeViewModel.currentDateTime.set("$day, $month, $year")
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun initViews(view: View?) {
    }

    override fun setupListeners() {
    }

    override fun loadData() {
    }

}