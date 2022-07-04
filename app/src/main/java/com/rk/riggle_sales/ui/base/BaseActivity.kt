package com.rk.riggle_sales.ui.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.rk.riggle_sales.App
import com.rk.riggle_sales.BR
import com.rk.riggle_sales.R
import com.rk.riggle_sales.data.local.SharedPrefManager
import com.rk.riggle_sales.data.network.ErrorCodes
import com.rk.riggle_sales.data.network.NetworkError
import com.rk.riggle_sales.ui.welcome.WelcomeActivity
import com.rk.riggle_sales.utils.AlertManager
import com.rk.riggle_sales.utils.connectivity.ConnectivityProvider
import com.rk.riggle_sales.utils.event.NoInternetSheet
import com.rk.riggle_sales.utils.hideKeyboard

abstract class BaseActivity<Binding : ViewDataBinding> : AppCompatActivity(),
    ConnectivityProvider.ConnectivityStateListener {
    //private var progressSheet: ProgressSheet? = null
    open val onRetry: (() -> Unit)? = null
    lateinit var binding: Binding
    val app: App
        get() = application as App

    private lateinit var connectivityProvider: ConnectivityProvider

    private var noInternetSheet: NoInternetSheet? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout: Int = getLayoutResource()
        binding = DataBindingUtil.setContentView(this, layout)
        val vm = getViewModel()
        binding.setVariable(BR.vm, vm)
        vm.onUnAuth.observe(this, Observer {
            showUnauthorised()
        })
        connectivityProvider = ConnectivityProvider.createProvider(this)
        connectivityProvider.addListener(this)
        onCreateView()
    }

    fun showUnauthorised() {
        if (SharedPrefManager.getCurrentUserId() == null)
            return
        showLogoutDialog()

    }

    var dialog: AlertDialog? = null
    private fun showLogoutDialog() {
        /*if (dialog != null && dialog!!.isShowing)
            dialog?.dismiss()*/

        if (dialog == null) {
            dialog = AlertDialog.Builder(this)
                .setTitle("Take In")
                .setMessage("User logged in using another device")
                .setCancelable(false)
                .setPositiveButton(
                    "Ok"
                ) { dialog, which ->
                    dialog.dismiss()
                    SharedPrefManager.clear()
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    finishAffinity()
                }
                .show()
        }

    }

    protected abstract fun getLayoutResource(): Int
    protected abstract fun getViewModel(): BaseViewModel
    protected abstract fun onCreateView()

    fun showToast(msg: String? = "Something went wrong !!") {
        Toast.makeText(this, msg ?: "Showed null value !!", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        hideKeyboard()
    }

    fun showLoading(s: Int) {
        showLoading(getString(s))
    }

    fun showLoading(s: String?) {
        /*progressSheet?.dismissAllowingStateLoss()
        progressSheet = ProgressSheet(object : ProgressSheet.BaseCallback {
            override fun onClick(view: View?) {}
            override fun onBind(bind: ViewProgressSheetBinding) {
                progressSheet?.showMessage(s);
            }
        })
        progressSheet?.isCancelable = false
        progressSheet?.show(supportFragmentManager, progressSheet?.tag)*/

    }

    fun hideLoading() {
        //progressSheet?.dismissAllowingStateLoss()
    }

    fun onError(error: Throwable, showErrorView: Boolean) {
        if (error is NetworkError) {
            //show if you have any error view
            /*   if (showErrorView) {
                   val errorView: View? = findViewById(R.id.errorView)
                   errorView?.visibility = View.VISIBLE
               }*/
            when (error.errorCode) {
                ErrorCodes.SESSION_EXPIRED -> {
                    showToast(getString(R.string.session_expired))
                    app.onLogout()
                }
                else -> AlertManager.showNegativeAlert(
                    this,
                    error.message,
                    getString(R.string.alert)
                )
            }
        } else {
            AlertManager.showNegativeAlert(
                this,
                getString(R.string.please_try_again),
                getString(R.string.alert)
            )
        }
    }


    override fun onDestroy() {
        //progressSheet?.dismissAllowingStateLoss()
        connectivityProvider.removeListener(this)
        super.onDestroy()
    }

    fun getAuthorization(): String {
        var authorization = ""
        SharedPrefManager.getToken()?.let {
            authorization = "Bearer " + it
        }
        return authorization
    }

    override fun onStateChange(state: ConnectivityProvider.NetworkState) {
        if (noInternetSheet == null) {
            noInternetSheet = NoInternetSheet()
            noInternetSheet?.setCancelable(false)
        }
        if (state.hasInternet()) {
            if (noInternetSheet?.isVisible == true)
                noInternetSheet?.dismiss()
        } else {
            if (noInternetSheet?.isVisible == false)
                noInternetSheet?.show(supportFragmentManager, noInternetSheet?.getTag())
        }
    }

    private fun ConnectivityProvider.NetworkState.hasInternet(): Boolean {
        return (this as? ConnectivityProvider.NetworkState.ConnectedState)?.hasInternet == true
    }

}