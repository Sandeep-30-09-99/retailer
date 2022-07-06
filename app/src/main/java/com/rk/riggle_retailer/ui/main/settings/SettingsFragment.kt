package com.rk.riggle_retailer.ui.main.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.FragmentSettingsBinding
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {


    companion object {
        const val TAG="SettingsFragment"
        @JvmStatic
        fun newInstance() =
            SettingsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_settings

    }

    private val viewModel: SettingsVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView(view: View) {

    }
}