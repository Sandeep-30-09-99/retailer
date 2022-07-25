package com.rk.riggle_retailer.ui.main.search_store


import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.FragmentSearchStoreBinding
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.ui.main.cart.CartFragment

import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class SearchStoreFragment : BaseFragment<FragmentSearchStoreBinding>() {

    private var mainActivity: MainActivity? = null
    private val viewModel: SearchStoreVM by viewModels()

    companion object {
        const val TAG = "SearchStoreFragment"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchStoreFragment().apply {

            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_search_store
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }


    override fun onCreateView(view: View) {
      //  setUpRecyclerView()
        mainActivity = activity as MainActivity
        binding.etSearchStore.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                if (binding.etSearchStore.text.toString().isEmpty()) {
                    binding.rvSearchAdapter.visibility = View.GONE
                } else {
                    binding.rvSearchAdapter.visibility = View.VISIBLE

                 //   searchAdapter?.list = filterList(binding.etSearchStore.text.toString())
                   // binding.rvSearchAdapter.adapter = searchAdapter
                }
            }
        })
        viewModel.onClick.observe(requireActivity()) {
            when (it.id) {
                R.id.card_cart -> {
                    mainActivity?.addSubFragment(TAG, CartFragment())
                }
                R.id.iv_back -> {
                    mainActivity?.onBackPressed()

                }
               /* R.id.tvNewStore -> {
                  //  mainActivity?.addSubFragment(TAG, CreateStoreFragment())
                    *//*val dialog =
                        BottomSheetDialog(requireActivity(), R.style.CustomBottomSheetDialogTheme)
                    val view = layoutInflater.inflate(R.layout.bs_order_created, null)
                    val bt = view.findViewById<TextView>(R.id.tvCollectPayment)
                    bt.setOnClickListener {
                        dialog.dismiss()
                    }
                   *//**//* val btcanel = view.findViewById<TextView>(R.id.tvCancel)
                    btcanel.setOnClickListener {
                        dialog.dismiss()
                    }*//**//*
                    dialog.setCancelable(true)
                    dialog.setContentView(view)
                    dialog.show()*//*

                }*/
            }

        }
    }
/*
    private var searchAdapter: SimpleRecyclerViewAdapter<DummyData, ListOfSearchItemsBinding>? =
        null


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
    private fun setUpRecyclerView() {
        searchAdapter = SimpleRecyclerViewAdapter<DummyData, ListOfSearchItemsBinding>(
            R.layout.list_of_search_items, BR.bean
        ) { v, m, pos ->
            when (v.id) {
                R.id.rlMain -> {
                    binding.etSearchStore.setText(m?.name!!)
                    binding.rvSearchAdapter.visibility = View.GONE
                }

            }
        }
        nameList = ArrayList<DummyData>()
        nameList?.add(DummyData("Sandeep", ""))
        nameList?.add(DummyData("Rahul", ""))
        searchAdapter?.list = nameList


        val suggestedAdapter = SimpleRecyclerViewAdapter<DummyData, ListOfSuggestedBinding>(
            R.layout.list_of_suggested, BR.bean
        ) { v, m, pos ->
            when (v.id) {
                R.id.rlMain -> {
                }

            }
            *//*  val layout = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
              binding.rvSuggested.layoutManager = layout*//*

        }
        val dummyList = ArrayList<DummyData>()
        dummyList.add(DummyData("", ""))
        dummyList.add(DummyData("", ""))
        suggestedAdapter.list = dummyList
        binding.rvSuggested.adapter = suggestedAdapter


    }*/
}


