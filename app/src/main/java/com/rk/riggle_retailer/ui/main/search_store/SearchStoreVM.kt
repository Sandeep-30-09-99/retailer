package com.rk.riggle_retailer.ui.main.search_store

import com.rk.riggle_retailer.data.api.ApiHelper
import com.rk.riggle_retailer.ui.base.BaseViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchStoreVM @Inject constructor(

    private val networkHelper: ApiHelper
) : BaseViewModel() {
}