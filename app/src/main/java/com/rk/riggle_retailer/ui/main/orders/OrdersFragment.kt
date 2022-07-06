package com.rk.riggle_retailer.ui.main.orders

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.FragmentOrderBinding
import com.rk.riggle_retailer.databinding.FragmentProfileBinding
import com.rk.riggle_retailer.ui.base.BaseFragment
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.utils.event.SingleLiveEvent

import com.rk_tech.riggle_runner.ui.main.neworder.ProfileFragmentVM

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : BaseFragment<FragmentOrderBinding>() {
    val viewModel: OrdersFragmentVM by viewModels()


    private var mainActivity: MainActivity? = null
    private var searchHandler: Handler = Handler(Looper.getMainLooper())

    companion object {

        var secondAdapterSet: Boolean = false
        val createMixClick = SingleLiveEvent<String>()
        fun newInstance(): Fragment {
            return OrdersFragment()
        }

        const val TAG = "OrderFragment"
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_order
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView(view: View) {
        mainActivity = requireActivity() as MainActivity

    }


}