package com.rk.riggle_retailer.ui.main.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyResponse
import com.rk.riggle_retailer.data.response.SettingsData
import com.rk.riggle_retailer.databinding.FragmentSettingBinding
import com.rk.riggle_retailer.databinding.ListOfSettingsBinding
import com.rk.riggle_retailer.databinding.ListOfTopCategoriesItemsBinding
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingBinding>() {


    companion object {
        const val TAG = "SettingsFragment"

        @JvmStatic
        fun newInstance() =
            SettingsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_setting

    }

    private val viewModel: SettingsVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView(view: View) {
        initSettingAdapter()
    }

    private lateinit var settingAdapter: SimpleRecyclerViewAdapter<SettingsData, ListOfSettingsBinding>
    private fun initSettingAdapter() {
        settingAdapter =
            SimpleRecyclerViewAdapter(R.layout.list_of_settings, BR.bean) { v, m, pos ->
            }
        val list = ArrayList<SettingsData>()
        list.add(
            SettingsData(
                R.drawable.ic_store,
                "MY STORE",
                "Manage your store information"
            )
        )
        list.add(
            SettingsData(
                R.drawable.ic_edit_pencil,
                "PROFILE",
                "Manage your personal details"
            )
        )
        list.add(SettingsData(R.drawable.ic_order, "MyOrder", "All your order history"))

        list.add(
            SettingsData(
                R.drawable.ic_briefcase__5__,
                "RIGGLE COINS",
                "See your earnings and benefits"
            )
        )
        list.add(SettingsData(R.drawable.ic_call_svg, "CONTACT US", "Need help? We’re listening and happy to assist"))
        settingAdapter.list = list
        binding.rvSettings.adapter = settingAdapter
    }


}