package com.dd.personalwallet.ui.notifications

import android.view.View
import com.dd.personalwallet.R
import com.dd.personalwallet.databinding.FragmentNotificationsBinding
import com.dd.personalwallet_core.fragment.BaseFragment

class NotificationsFragment : BaseFragment<NotificationsViewModel, FragmentNotificationsBinding>() {

    override fun getLayoutId() = R.layout.fragment_notifications

    override fun initViews(view: View?) {}

    override fun setupListeners() {}

    override fun loadData() {}
}