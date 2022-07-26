package com.rk.riggle_retailer.ui.main.setting

import com.rk.riggle_retailer.data.api.ApiHelper
import com.rk.riggle_retailer.ui.base.BaseViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingVM @Inject constructor(

    private val networkHelper: ApiHelper
) : BaseViewModel() {
}