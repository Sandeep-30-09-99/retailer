package com.rk.riggle_retailer.ui.main.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.FragmentCartBinding
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>() {

    companion object {

        const  val TAG = "CartFragment"
          @JvmStatic
        fun newInstance() =
            CartFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_cart
    }

    private val viewModel : CartFragmentVM by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel

    }

    override fun onCreateView(view: View) {

    }
}