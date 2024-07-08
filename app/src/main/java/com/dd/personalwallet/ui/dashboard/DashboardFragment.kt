package com.dd.personalwallet.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dd.personalwallet.R
import com.dd.personalwallet.databinding.FragmentDashboardBinding
import com.dd.personalwallet.viewModel.DashboardViewModel
import com.dd.personalwallet_core.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<DashboardViewModel, FragmentDashboardBinding>() {

     private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = dashboardViewModel

        dashboardViewModel.responseData.observe(viewLifecycleOwner) {
            dashboardViewModel.isButtonVisibility.set(true)
        }
    }

    override fun getLayoutId() = R.layout.fragment_dashboard

    override fun initViews(view: View?) {
    }

    override fun setupListeners() {
    }

    override fun loadData() {
    }
}