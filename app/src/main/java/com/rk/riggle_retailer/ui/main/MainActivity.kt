package com.rk.riggle_retailer.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels


import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.ActivityMainBinding
import com.rk.riggle_retailer.ui.base.BaseActivity
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.main.cart.CartFragment
import com.rk.riggle_retailer.ui.main.credit.CreditFragment
import com.rk.riggle_retailer.ui.main.new_orders.NewOrderFragment
import com.rk.riggle_retailer.ui.main.home.HomeFragment
import com.rk.riggle_retailer.ui.main.settings.SettingsFragment
import com.rk.riggle_retailer.utils.BackStackManager
import com.rk_tech.riggle_runner.ui.main.main.MainViewModel

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModels()

    /*private lateinit var adapter: MainAdapter*/
    companion object {
        fun newIntent(activity: Activity): Intent {
            val intent = Intent(activity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        //   window.statusBarColor = ContextCompat.getColor(this, R.color.black_theme)
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): BaseViewModel {
        return mainViewModel
    }

    override fun onCreateView() {
        binding.selected = 1
        mainViewModel.onClick.observe(this, Observer {
            when (it?.id) {
                R.id.llOne -> {
                    binding.selected = 1
                    changeFragment(HomeFragment.TAG)
                }
                R.id.llTwo -> {
                    binding.selected = 2
                    changeFragment(NewOrderFragment.TAG)
                }
                R.id.llThree -> {
                    binding.selected = 3
                    changeFragment(CartFragment.TAG)
                }
                R.id.llFour -> {
                    binding.selected = 4
                    changeFragment(CreditFragment.TAG)
                }
                R.id.llFive -> {
                    binding.selected = 5
                    changeFragment(SettingsFragment.TAG)
                }
            }
        })
        /*setupUI()
        setupObserver()*/
        BackStackManager.getInstance(this).clear()
         changeFragment(HomeFragment.TAG)
    }

    private fun changeFragment(tag: String?) {
        tag?.let {
            when (it) {
                HomeFragment.TAG -> {
                    BackStackManager.getInstance(this)
                        .pushFragments(
                            R.id.flContainer,
                            it,
                            HomeFragment.newInstance(),
                            true
                        )
                }
                NewOrderFragment.TAG -> {
                    BackStackManager.getInstance(this)
                        .pushFragments(R.id.flContainer, it, NewOrderFragment.newInstance(), true)
                }
                SettingsFragment.TAG -> {
                    BackStackManager.getInstance(this)
                        .pushFragments(R.id.flContainer, it, SettingsFragment.newInstance(), true)
                }
                CartFragment.TAG -> {
                    BackStackManager.getInstance(this)
                        .pushFragments(R.id.flContainer, it, CartFragment.newInstance(), true)
                }
                CreditFragment.TAG -> {
                    BackStackManager.getInstance(this)
                        .pushFragments(R.id.flContainer, it, CreditFragment.newInstance(), true)
                }
            }
        }
    }

    open fun addSubFragment(tag: String, fragment: Fragment) {
        BackStackManager.getInstance(this)
            .pushSubFragments(R.id.flContainer, tag, fragment, true)
    }

    override fun onBackPressed() {
        if (isPopupBack()) {
            super.onBackPressed()
        }
    }

    private fun isPopupBack(): Boolean {
        return BackStackManager.getInstance(this).removeFragment(R.id.flContainer, true)
    }

    /*private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.users.observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }*/

}
