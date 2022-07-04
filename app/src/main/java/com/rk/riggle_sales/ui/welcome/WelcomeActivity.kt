package com.rk.riggle_sales.ui.welcome

import androidx.activity.viewModels
import com.rk.riggle_sales.R
import com.rk.riggle_sales.databinding.ActivityWelcomeBinding
import com.rk.riggle_sales.ui.base.BaseActivity
import com.rk.riggle_sales.ui.base.BaseViewModel
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