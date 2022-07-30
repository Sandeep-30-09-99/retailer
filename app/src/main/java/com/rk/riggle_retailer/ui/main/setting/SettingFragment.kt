package com.rk.riggle_retailer.ui.main.setting


import android.view.View
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.BR
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyData
import com.rk.riggle_retailer.databinding.FragmentSettingBinding
import com.rk.riggle_retailer.databinding.ListOfSearchItemsBinding
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.ui.main.cart.CartFragment

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding>() {

    private var mainActivity: MainActivity? = null
    private val viewModel: SettingVM by viewModels()

    companion object {
        const val TAG = "SearchStoreFragment"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingFragment().apply {

            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_setting
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }


    override fun onCreateView(view: View) {
        setUpRecyclerView()
        mainActivity = activity as MainActivity
        viewModel.onClick.observe(requireActivity()) {
            when (it.id) {
                R.id.card_cart -> {
                    mainActivity?.addSubFragment(TAG, CartFragment())
                }
                R.id.iv_back -> {
                    mainActivity?.onBackPressed()

                }

            }

        }
    }


    private fun filterList(text: String): ArrayList<DummyData> {
        val list = ArrayList<DummyData>()
        nameList?.let {
            for (i in nameList?.indices!!) {
                if (nameList?.get(i)?.name?.contains(text, true) == true) {
                    list.add(nameList?.get(i)!!)
                }
            }
            return list
        }
        return list
    }

    private var nameList: ArrayList<DummyData>? = null
    private var searchAdapter: SimpleRecyclerViewAdapter<DummyData, ListOfSearchItemsBinding>? =
        null

    private fun setUpRecyclerView() {
        searchAdapter = SimpleRecyclerViewAdapter<DummyData, ListOfSearchItemsBinding>(
            R.layout.list_of_search_items,BR.bean
        ) { v, m, pos ->
            when (v.id) {
                R.id.rlMain -> {

                }

            }
        }
        nameList = ArrayList<DummyData>()
        nameList?.add(DummyData("Sandeep", ""))
        nameList?.add(DummyData("Rahul", ""))
        searchAdapter?.list = nameList

    }


}


