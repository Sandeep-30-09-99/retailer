package com.rk.riggle_retailer.ui.welcome

import androidx.activity.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.ActivityWelcomeBinding
import com.rk.riggle_retailer.ui.base.BaseActivity
import com.rk.riggle_retailer.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>() {

    private val viewmodel: WelcomeActivityVM by viewModels()

    override fun getLayoutResource(): Int {
        return R.layout.activity_welcome
    }

    override fun getViewModel(): BaseViewModel {
        return viewmodel
    }

    override fun onCreateView() {

    }

}