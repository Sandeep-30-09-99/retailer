package com.rk.riggle_retailer.ui.main.credit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.FragmentCartBinding
import com.rk.riggle_retailer.databinding.FragmentCreditBinding
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.cart.CartFragment
import com.rk.riggle_retailer.ui.main.cart.CartFragmentVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreditFragment  : BaseFragment<FragmentCreditBinding>() {

    companion object {
        const  val TAG = "CreditFragment"
        @JvmStatic
        fun newInstance() =
            CartFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_credit
    }

    private val viewModel : CreditVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel

    }

    override fun onCreateView(view: View) {

    }
}