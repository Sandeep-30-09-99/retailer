package com.rk.riggle_retailer.ui.main.cart

import com.rk.riggle_retailer.data.api.ApiHelper
import com.rk.riggle_retailer.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartFragmentVM @Inject constructor(private val apiHelper: ApiHelper):BaseViewModel() {

}