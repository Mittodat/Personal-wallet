package com.dd.personalwallet_core.iinterface

interface IFragment : IContext {

    fun getLayoutId(): Int

    fun getTagName(): String

    fun onViewDisappear()

}