package com.rk.riggle_retailer.ui.main.new_orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.FragmentCreditBinding
import com.rk.riggle_retailer.databinding.FragmentNewOrderBinding
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.cart.CartFragment
import com.rk.riggle_retailer.ui.main.credit.CreditVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewOrderFragment : BaseFragment<FragmentNewOrderBinding>() {

    companion object {
        const  val TAG = "NewOrderFragment"
        @JvmStatic
        fun newInstance() =
            CartFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_new_order
    }

    private val viewModel : NewOrderVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel

    }

    override fun onCreateView(view: View) {

    }
}