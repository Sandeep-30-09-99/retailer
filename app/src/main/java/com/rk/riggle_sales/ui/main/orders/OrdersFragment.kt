package com.rk.riggle_sales.ui.main.orders

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rk.riggle_sales.R
import com.rk.riggle_sales.databinding.FragmentProfileBinding
import com.rk.riggle_sales.ui.base.BaseFragment
import com.rk.riggle_sales.ui.base.BaseViewModel
import com.rk.riggle_sales.ui.main.MainActivity
import com.rk.riggle_sales.utils.event.SingleLiveEvent

import com.rk_tech.riggle_runner.ui.main.neworder.ProfileFragmentVM

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : BaseFragment<FragmentProfileBinding>() {
    val viewModel: ProfileFragmentVM by viewModels()


    private var mainActivity: MainActivity? = null
    private var searchHandler: Handler = Handler(Looper.getMainLooper())

    companion object {
        var secondAdapterSet: Boolean = false
        val createMixClick = SingleLiveEvent<String>()
        fun newInstance(): Fragment {
            return OrdersFragment()
        }

        val TAG = "NewOrderFragment"
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_profile
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView(view: View) {
        mainActivity = requireActivity() as MainActivity

        }


    }
