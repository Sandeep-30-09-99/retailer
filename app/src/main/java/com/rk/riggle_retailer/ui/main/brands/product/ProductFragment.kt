package com.rk.riggle_retailer.ui.main.brands.product

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyData
import com.rk.riggle_retailer.data.response.SettingsData
import com.rk.riggle_retailer.databinding.FragmentBrandBinding
import com.rk.riggle_retailer.databinding.FragmentProductBinding
import com.rk.riggle_retailer.databinding.ListOfSettingsBinding
import com.rk.riggle_retailer.databinding.ListOfSuggestedProductsBinding
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.ui.main.profile.edit_profile.ProfileFragment
import com.rk.riggle_retailer.ui.main.settings.SettingsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>() {

    companion object {
        const val TAG = "ProductFragment"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_product
    }

    private val viewModel: ProductFragmentVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }


    private var mainActivity: MainActivity? = null
    override fun onCreateView(view: View) {
        mainActivity = activity as MainActivity
        initRelatedAdapter()
    }


    private lateinit var relatedProduct: SimpleRecyclerViewAdapter<DummyData, ListOfSuggestedProductsBinding>
    private fun initRelatedAdapter() {
        relatedProduct =
            SimpleRecyclerViewAdapter(R.layout.list_of_suggested_products, BR.bean) { v, m, pos ->

            }
        val list = ArrayList<DummyData>()
        list.add(DummyData("", ""))
        list.add(DummyData("", ""))
        list.add(DummyData("", ""))
        list.add(DummyData("", ""))
        list.add(DummyData("", ""))
        relatedProduct.list = list
        binding.rvRelatedProduct.adapter = relatedProduct
    }
}