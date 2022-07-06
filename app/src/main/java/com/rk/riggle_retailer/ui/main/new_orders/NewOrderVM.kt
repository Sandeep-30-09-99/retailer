package com.rk.riggle_retailer.ui.main.new_orders

import com.rk.riggle_retailer.data.api.ApiHelper
import com.rk.riggle_retailer.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewOrderVM @Inject constructor(private val apiHelper: ApiHelper) :BaseViewModel(){

}