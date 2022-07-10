package com.rk.riggle_retailer.ui.main.brands.sub_category

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyResponse
import com.rk.riggle_retailer.databinding.FragmentSubCategoriesBinding
import com.rk.riggle_retailer.databinding.ListOfSubCategoryBinding
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.ui.main.brands.BrandFragment
import com.rk.riggle_retailer.ui.main.brands.products.ProductsFragment
import com.rk.riggle_retailer.ui.main.new_orders.NewOrderFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubCategoryFragment : BaseFragment<FragmentSubCategoriesBinding>() {

    companion object {
        const val TAG = "SubCategory"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SubCategoryFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_sub_categories
    }

    private val viewModel: SubCategoryFragmentVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    private var mainActivity: MainActivity? = null
    override fun onCreateView(view: View) {
        mainActivity = requireActivity() as MainActivity
        initCategoryAdapter()
    }

    private lateinit var subCategoryAdapter: SimpleRecyclerViewAdapter<DummyResponse, ListOfSubCategoryBinding>


    private fun initCategoryAdapter() {
        subCategoryAdapter =
            SimpleRecyclerViewAdapter(R.layout.list_of_sub_category, BR.bean) { v, m, pos ->
                mainActivity?.addSubFragment(NewOrderFragment.TAG, ProductsFragment())
            }
        val list = ArrayList<DummyResponse>()
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        subCategoryAdapter.list = list
        binding.rvSubCategories.adapter = subCategoryAdapter
    }
}