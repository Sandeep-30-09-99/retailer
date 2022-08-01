package com.rk.riggle_retailer.ui.main.new_orders

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyData
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
        setUpRecyclerView()
        setUpResultAdapter()
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                if (binding.etSearch.text.toString().isEmpty()) {
                    binding.rvSearchAdapter.visibility = View.GONE
                } else {
                    binding.rvSearchAdapter.visibility = View.VISIBLE
                    searchAdapter?.list = filterList(binding.etSearch.text.toString())
                    binding.rvSearchAdapter.adapter = searchAdapter
                }
            }
        })
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
            R.layout.list_of_search_items, com.rk.riggle_retailer.BR.bean
        ) { v, m, pos ->
            when (v.id) {
                R.id.rlMain -> {
                    binding.etSearch.setText(m?.name!!)
                    binding.rvSearchAdapter.visibility = View.GONE
                }

            }
        }
        nameList = ArrayList<DummyData>()
        nameList?.add(DummyData("Sandeep", ""))
        nameList?.add(DummyData("Rahul", ""))
        searchAdapter?.list = nameList

    }


    private var resultAdapter: SimpleRecyclerViewAdapter<DummyData, ListOfProductsBinding>? =
        null

    private fun setUpResultAdapter() {
        resultAdapter = SimpleRecyclerViewAdapter<DummyData, ListOfProductsBinding>(
            R.layout.list_of_products, com.rk.riggle_retailer.BR.bean
        ) { v, m, pos ->
            when (v.id) {
                R.id.rlMain -> {

                }

            }
        }
        nameList = ArrayList<DummyData>()
        nameList?.add(DummyData("Sandeep", ""))
        nameList?.add(DummyData("Rahul", ""))
        resultAdapter?.list = nameList

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