package com.dd.personalwallet.ui.dashboard

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dd.personalwallet.R
import com.dd.personalwallet.data.CareEmployee
import com.dd.personalwallet.data.ShoppingBanner
import com.dd.personalwallet.databinding.FragmentDashboardBinding
import com.dd.personalwallet.databinding.LayoutItemDashboardBannerBinding
import com.dd.personalwallet.databinding.LayoutItemEmployeeBinding
import com.dd.personalwallet.ui.SpacingItemDecoration
import com.dd.personalwallet.viewModel.DashboardViewModel
import com.dd.personalwallet_core.fragment.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<DashboardViewModel, FragmentDashboardBinding>() {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    private val scrollHandler = Handler(Looper.getMainLooper())
    private var currentIndex = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = dashboardViewModel

        val layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )

        dashboardViewModel.getCareEmployeeList()
        dashboardViewModel.getBannerList()

        dashboardViewModel.responseData.observe(viewLifecycleOwner) {
            dashboardViewModel.isButtonVisibility.set(true)
        }

        dashboardViewModel.careEmployee.observe(viewLifecycleOwner) {
            val spacing = resources.getDimensionPixelSize(R.dimen.dashBroad_item_spacing)
            binding.employeeList.apply {
                this.layoutManager = layoutManager
                this.adapter = EmployeeAdapter(it)
//                this.addItemDecoration(SpacingItemDecoration(spacingHorizontal = spacing, 0))
            }
        }

        dashboardViewModel.bannerShopping.observe(viewLifecycleOwner) {
            binding.bannerViewPager.adapter = BannerAdapter(it)
            TabLayoutMediator(binding.indicatorTabLayout, binding.bannerViewPager) { _, _ -> }.attach()

            startAutoScroll(it)
        }
    }

    class ViewHolder(val binding: LayoutItemEmployeeBinding) : RecyclerView.ViewHolder(binding.root)

    inner class EmployeeAdapter(private val careEmployees: List<CareEmployee>) : RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = LayoutItemEmployeeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return ViewHolder(binding)
        }

        override fun getItemCount() = careEmployees.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.nameTxt.text = careEmployees[position].name
            holder.binding.ageTxt.text = careEmployees[position].age.toString()
        }
    }

    class BannerViewHolder(val binding: LayoutItemDashboardBannerBinding) : RecyclerView.ViewHolder(binding.root)

    inner class BannerAdapter(private val items: List<ShoppingBanner>) : RecyclerView.Adapter<BannerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
            val binding = LayoutItemDashboardBannerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return BannerViewHolder(binding)
        }

        override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
            val item = items[position]
            Glide.with(requireContext())
                .load(item.image)
                .into(holder.binding.bannerImg)
        }

        override fun getItemCount(): Int = items.size
    }

    private fun startAutoScroll(bannerItems: List<ShoppingBanner>) {
        scrollHandler.postDelayed(object : Runnable {
            override fun run() {
                currentIndex = (currentIndex + 1) % bannerItems.size
                binding.bannerViewPager.currentItem = currentIndex
                scrollHandler.postDelayed(this, 3000) // 3-second interval
            }
        }, 3000)
    }

    override fun getLayoutId() = R.layout.fragment_dashboard

    override fun initViews(view: View?) {
    }

    override fun setupListeners() {
    }

    override fun loadData() {
    }
}