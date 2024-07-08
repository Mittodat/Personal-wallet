package com.dd.personalwallet_core.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {
    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding

    private lateinit var _viewModel: VM
    protected val viewModel: VM
        get() = _viewModel

    abstract fun createBinding(): VB
    abstract fun createViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = createBinding()
        setContentView(binding.root)

        _viewModel = createViewModel()

        // Additional setup if needed
        setupViews()
        observeViewModel()
    }

    open fun setupViews() {
        // Override this method in subclasses to perform additional view setup
    }

    open fun observeViewModel() {
        // Override this method in subclasses to observe ViewModel events
    }
}
