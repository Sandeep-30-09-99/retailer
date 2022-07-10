package com.rk.riggle_retailer.ui.main.brands

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyResponse
import com.rk.riggle_retailer.databinding.FragmentBrandBinding
import com.rk.riggle_retailer.databinding.ListOfBrandsBinding
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.ui.main.brands.sub_category.SubCategoryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BrandFragment : BaseFragment<FragmentBrandBinding>() {

    companion object {
        const val TAG = "BrandFragment"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BrandFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_brand
    }

    private val viewModel: BrandFragmentVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    private var mainActivity: MainActivity? = null
    override fun onCreateView(view: View) {
        mainActivity = requireActivity() as MainActivity
        initCategoryAdapter()
    }

    private lateinit var brandsAdpater: SimpleRecyclerViewAdapter<DummyResponse, ListOfBrandsBinding>

    private fun initCategoryAdapter() {
        brandsAdpater =
            SimpleRecyclerViewAdapter(R.layout.list_of_brands, BR.bean) { v, m, pos ->
                mainActivity?.addSubFragment(TAG, SubCategoryFragment())
            }
        val list = ArrayList<DummyResponse>()
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        brandsAdpater.list = list
        binding.rvBrands.adapter = brandsAdpater
    }
}