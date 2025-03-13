package com.dd.personalwallet.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dd.personalwallet.R
import com.dd.personalwallet.databinding.FragmentDashboardBinding
import com.dd.personalwallet.utils.DateTimeUtils
import com.dd.personalwallet.viewModel.DashBoardViewModel
import com.dd.personalwallet_core.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<DashBoardViewModel, FragmentDashboardBinding>() {

    private val dashBoardViewModel: DashBoardViewModel by viewModels()

    private var tabLayoutModels = listOf<Fragment>()

    @SuppressLint("DefaultLocale")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = dashBoardViewModel
        val now = DateTimeUtils.getCurrentDate()
        val day = String.format("%02d", now[0])
        val month = String.format("%02d", now[1])
        val year = now[2]

        dashBoardViewModel.currentDateTime.set("$day, $month, $year")
    }

    override fun getLayoutId() = R.layout.fragment_dashboard

    override fun initViews(view: View?) {
    }

    override fun setupListeners() {
    }

    override fun loadData() {
    }
}