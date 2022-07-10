package com.rk.riggle_retailer.ui.main.brands.products

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyResponse
import com.rk.riggle_retailer.databinding.FragmentProductsBinding
import com.rk.riggle_retailer.databinding.ListOfProductsBinding
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.ui.main.brands.product.ProductFragment
import com.rk.riggle_retailer.ui.main.brands.sub_category.SubCategoryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>() {

    companion object {
        const val TAG = "ProductsFragment"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_products
    }

    private val viewModel: ProductsFragmentVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    private var mainActivity: MainActivity? = null
    override fun onCreateView(view: View) {
        mainActivity = requireActivity() as MainActivity
        initCategoryAdapter()
    }

    private lateinit var producstsAdapter: SimpleRecyclerViewAdapter<DummyResponse, ListOfProductsBinding>


    private fun initCategoryAdapter() {
        producstsAdapter =
            SimpleRecyclerViewAdapter(R.layout.list_of_products, BR.bean) { v, m, pos ->
                mainActivity?.addSubFragment(TAG, ProductFragment())
            }
        val list = ArrayList<DummyResponse>()
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        producstsAdapter.list = list
        binding.rvProducts.adapter = producstsAdapter
    }
}