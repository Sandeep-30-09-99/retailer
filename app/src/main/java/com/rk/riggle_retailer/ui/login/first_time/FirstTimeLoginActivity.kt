package com.rk.riggle_retailer.ui.login.first_time

import android.app.Activity
import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.rk.riggle_retailer.BR
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.data.response.DummyData
import com.rk.riggle_retailer.databinding.LayoutFirsttimeLoginBinding
import com.rk.riggle_retailer.databinding.ListOfRolesBinding
import com.rk.riggle_retailer.databinding.ListOfStoreTypeBinding
import com.rk.riggle_retailer.di.base.SimpleRecyclerViewAdapter
import com.rk.riggle_retailer.ui.base.BaseActivity
import com.rk.riggle_retailer.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_product.view.*
import kotlinx.android.synthetic.main.layout_firsttime_login.*

@AndroidEntryPoint
class FirstTimeLoginActivity : BaseActivity<LayoutFirsttimeLoginBinding>() {

    val viewModel: FirstTimeLoginVM by viewModels()

    companion object {
        fun newIntent(activity: Activity): Intent {
            val intent = Intent(activity, FirstTimeLoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            return intent
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.layout_firsttime_login
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView() {
        setUpStoreTypeRV()
        setUpRoleRV()
        showLayout(1)
        viewModel.onClick.observe(this) {
            when (it?.id) {
                R.id.btn_next -> {
                    if (binding.deactive == true) {
                        return@observe
                    }
                    if (binding.active == 1) {
                        showLayout(2)
                    } else if (binding.active == 2) {
                        showLayout(3)
                    }
                }
            }
        }

    }

    private fun showLayout(no: Int) {
        binding.active = no
        when (no) {
            1 -> {
                store_info.visibility = View.VISIBLE
                business_info.visibility = View.GONE
                owner_info.visibility = View.GONE

            }
            2 -> {
                store_info.visibility = View.GONE
                business_info.visibility = View.VISIBLE
                owner_info.visibility = View.GONE

            }
            3 -> {
                store_info.visibility = View.GONE
                business_info.visibility = View.GONE
                owner_info.visibility = View.VISIBLE

            }
        }
    }

    private var storeTypeAdapter: SimpleRecyclerViewAdapter<DummyData, ListOfStoreTypeBinding>? =
        null

    private fun setUpStoreTypeRV() {
        storeTypeAdapter = SimpleRecyclerViewAdapter<DummyData, ListOfStoreTypeBinding>(
            R.layout.list_of_store_type, BR.bean
        ) { v, m, pos ->
            when (v.id) {
                R.id.rlMain -> {


                }

            }
        }
        val storeList = ArrayList<DummyData>()
        storeList.add(DummyData("Sandeep", ""))
        storeList.add(DummyData("Rahul", ""))
        storeTypeAdapter?.list = storeList
        binding.storeInfo.rvStoreType.adapter = storeTypeAdapter
    }

    private var rolesAdapter: SimpleRecyclerViewAdapter<DummyData, ListOfRolesBinding>? =
        null

    private fun setUpRoleRV() {
        rolesAdapter = SimpleRecyclerViewAdapter<DummyData, ListOfRolesBinding>(
            R.layout.list_of_roles, BR.bean
        ) { v, m, pos ->
            when (v.id) {
                R.id.rlMain -> {


                }

            }
        }
        val storeList = ArrayList<DummyData>()
        storeList.add(DummyData("Sandeep", ""))
        storeList.add(DummyData("Rahul", ""))
        rolesAdapter?.list = storeList
        binding.ownerInfo.rvRoles.adapter = rolesAdapter
    }


}