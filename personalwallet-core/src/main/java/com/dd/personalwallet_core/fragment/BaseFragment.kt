package com.dd.personalwallet_core.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.dd.personalwallet_core.iinterface.IFragment

abstract class BaseFragment <viewModel: ViewModel, VB: ViewDataBinding>: Fragment(), IFragment {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun getTagName() = ""

    override fun onViewDisappear() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViews(view)
        setupListeners()
        loadData()
        _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    // Optional: Initialize views in child fragments
    abstract fun initViews(view: View?)

    // Optional: Setup listeners in child fragments
    abstract fun setupListeners()

    // Optional: Load data in child fragments
    abstract fun loadData()

}