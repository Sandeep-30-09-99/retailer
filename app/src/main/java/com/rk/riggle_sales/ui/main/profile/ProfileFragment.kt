package com.rk.riggle_sales.ui.main.profile

import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.rk.riggle_sales.R
import com.rk.riggle_sales.databinding.FragmentProfileBinding
import com.rk.riggle_sales.ui.base.BaseFragment
import com.rk.riggle_sales.ui.base.BaseViewModel
import com.rk.riggle_sales.ui.main.MainActivity
import com.rk.riggle_sales.utils.event.SingleLiveEvent

import com.rk_tech.riggle_runner.ui.main.neworder.ProfileFragmentVM

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    val viewModel: ProfileFragmentVM by viewModels()


    private var mainActivity: MainActivity? = null
    private var searchHandler: Handler = Handler(Looper.getMainLooper())

    companion object {
        var secondAdapterSet: Boolean = false
        val createMixClick = SingleLiveEvent<String>()
        fun newInstance(): Fragment {
            return ProfileFragment()
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
