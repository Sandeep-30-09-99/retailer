package com.rk.riggle_retailer.ui.main.home

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyResponse
import com.rk.riggle_retailer.databinding.FragmentHomeBinding
import com.rk.riggle_retailer.databinding.ListOfTopCategoriesBinding
import com.rk.riggle_retailer.databinding.ListOfTopCategoriesItemsBinding
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    val viewModel: HomeFragmentVM by viewModels()


    private var searchHandler: Handler = Handler(Looper.getMainLooper())

    companion object {
        fun newInstance(): Fragment {
            return HomeFragment()
        }

        const val TAG = "OrderFragment"
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_home
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    private var mainActivity: MainActivity? = null
    override fun onCreateView(view: View) {
        mainActivity = requireActivity() as MainActivity
        initCategoryAdapter()
    }

    private lateinit var categoryAdapter: SimpleRecyclerViewAdapter<DummyResponse, ListOfTopCategoriesItemsBinding>


    private fun initCategoryAdapter() {
        categoryAdapter =
            SimpleRecyclerViewAdapter(R.layout.list_of_top_categories_items, BR.bean) { v, m, pos ->
            }
        val list = ArrayList<DummyResponse>()
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        list.add(DummyResponse("", ""))
        categoryAdapter.list = list
        binding.newCustomer.rvOtherCategories.adapter = categoryAdapter
        binding.newCustomer.rvCategories.adapter = categoryAdapter
    }

}
