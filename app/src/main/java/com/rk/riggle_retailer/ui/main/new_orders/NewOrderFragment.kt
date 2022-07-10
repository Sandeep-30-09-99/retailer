package com.rk.riggle_retailer.ui.main.new_orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyResponse
import com.rk.riggle_retailer.databinding.*
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.ui.main.brands.BrandFragment
import com.rk.riggle_retailer.ui.main.cart.CartFragment
import com.rk.riggle_retailer.ui.main.credit.CreditVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewOrderFragment : BaseFragment<FragmentNewOrderBinding>() {

    companion object {
        const val TAG = "NewOrderFragment"

        @JvmStatic
        fun newInstance() =
            NewOrderFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_new_order
    }

    private lateinit var mainActivity: MainActivity
    private val viewModel: NewOrderVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel

    }

    override fun onCreateView(view: View) {
        mainActivity = activity as MainActivity
        initCategoryAdapter()
    }

    private lateinit var categoryAdapter: SimpleRecyclerViewAdapter<DummyResponse, ListOfTopCategoriesItemsBinding>
    private lateinit var couponAdpater: SimpleRecyclerViewAdapter<DummyResponse, ListOfCouponsBinding>
    private lateinit var brandAdapter: SimpleRecyclerViewAdapter<DummyResponse, HolderBrandBinding>
    private lateinit var distributorAdpater: SimpleRecyclerViewAdapter<DummyResponse, ListOfDistributorBinding>
    private fun initCategoryAdapter() {
        categoryAdapter =
            SimpleRecyclerViewAdapter(R.layout.list_of_top_categories_items, BR.bean) { v, m, pos ->
                mainActivity.addSubFragment(TAG, BrandFragment())
            }
        couponAdpater =
            SimpleRecyclerViewAdapter(R.layout.list_of_coupons, BR.bean) { v, m, pos ->
                mainActivity.addSubFragment(TAG, BrandFragment())
            }

        brandAdapter =
            SimpleRecyclerViewAdapter(R.layout.holder_brand, BR.bean) { v, m, pos ->
                mainActivity.addSubFragment(TAG, BrandFragment())
            }
        distributorAdpater =
            SimpleRecyclerViewAdapter(R.layout.list_of_distributor, BR.bean) { v, m, pos ->
                mainActivity.addSubFragment(TAG, BrandFragment())
            }

        val list = ArrayList<DummyResponse>()
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        categoryAdapter.list = list
        brandAdapter.list = list
        couponAdpater.list = list
        distributorAdpater.list = list
        binding.rvCategories.adapter = categoryAdapter
        binding.rvOtherCategories.adapter = categoryAdapter
        binding.rvShopByBrand.adapter = brandAdapter
        binding.rvCoupons.adapter = couponAdpater
        binding.rvShopByDistribtor.adapter = distributorAdpater

    }
}