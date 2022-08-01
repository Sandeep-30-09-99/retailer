package com.rk.riggle_retailer.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.CountDownTimer
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.rk.riggle_retailer.R
import com.rk.riggle_retailer.databinding.ActivityLoginBinding
import com.rk.riggle_retailer.ui.base.BaseActivity
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.ui.login.first_time.FirstTimeLoginActivity
import com.rk.riggle_retailer.ui.main.MainActivity
import com.rk.riggle_retailer.utils.showInfoToast
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private var countDownTimer: CountDownTimer? = null
    val viewModel: LoginActivityVM by viewModels()

    companion object {
        fun newIntent(activity: Activity): Intent {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            return intent
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_login
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView() {
        viewModel.onClick.observe(this) {
            when (it?.id) {
                R.id.btn_next -> {
                    if (binding.vBottom.deactive == true)
                        return@observe
                    if (!binding.cbox.isChecked) {
                        showInfoToast("Accept terms and conditions!")
                        return@observe
                    }
                    if (isOtpView()) {
                        verifyOtp()

                    } else {
                        sendOtp()
                    }
                }
            }
        }
        viewModel.obrVerifyOtp.observe(this, Observer {
            /*when (it.status) {
                Status.LOADING -> {
                    showLoading("Loading")
                }
                Status.SUCCESS -> {
                    hideLoading()
                    startActivity(MainActivity.newIntent(this))
                }
                Status.WARN -> {
                    hideLoading()
                    showInfoToast(it.message.toString())
                }

                Status.ERROR -> {
                    hideLoading()
                    showErrorToast(it.message.toString())
                }
            }*/
        })

        /*  viewModel.obrverify.observe(
              this,
              SingleRequestEvent.RequestObserver { resource ->
                  when (resource.status) {
                      Status.LOADING -> showLoading(R.string.plz_wait)
                      Status.SUCCESS -> {
                          hideLoading()
                          resource.data?.let {
                              startNewActivity(WelcomeActivity::class.java, true)
                          }
                      }
                      else -> {
                          hideLoading()
                          showErrorToast(resource.message)
                      }
                  }
              })

          viewModel.obrOtp.observe(
              this,
              SingleRequestEvent.RequestObserver { resource ->
                  when (resource.status) {
                      Status.LOADING -> showLoading(R.string.plz_wait)
                      Status.SUCCESS -> {
                          hideLoading()
                          resource.data?.asJsonObject?.get("message")?.asString?.let {
                              showSuccessToast(it)
                              showOtpView()
                              startTimer()
                          }
                      }
                      else -> {
                          hideLoading()
                          showErrorToast(resource.message)
                      }
                  }
              })
    */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
          /*  binding.terms.text =
                Html.fromHtml(
                    getString(R.string.terms_message),
                    Html.FROM_HTML_MODE_COMPACT
                )*/
        };
        binding.terms.movementMethod = LinkMovementMethod.getInstance();
        binding.vBottom.tvSkip.visibility = View.INVISIBLE
        binding.vBottom.deactive = true
        initPhone()
        hideOtpView()
    }

    private fun sendOtp() {
        hideOtpView()
        when {
            viewModel.field_phone.get().isNullOrBlank() -> {
                binding.etEmail.error = "Invalid"
            }
            else -> {
                val parm = JSONObject()
                parm.put("mobile", viewModel.field_phone.get().toString())
               /* val body = SendOtpBean(viewModel.field_phone.get().toString())
                viewModel.getOtp(body)*/
                showOtpView()
            }
        }
    }

    private fun verifyOtp() {
        startActivity(FirstTimeLoginActivity.newIntent(this))
        when {
            viewModel.field_otp.get().isNullOrBlank() -> {
                binding.etotp.error = "Invalid"
            }
            else -> {
               /* val parm = VerifyOtp(
                    binding.etEmail.text.toString(),
                    "sandeep",
                    binding.etotp.text.toString(),
                    "160059"
                )
                viewModel.verifyOtp(parm)*/
                startActivity(FirstTimeLoginActivity.newIntent(this))
            }
        }
    }

    private fun hideOtpView() {
        binding.tvotp.visibility = View.GONE
        binding.etotp.visibility = View.GONE
        binding.etEmail.isEnabled = true
    }

    private fun showOtpView() {
        binding.tvotp.visibility = View.VISIBLE
        binding.etotp.visibility = View.VISIBLE
        binding.etEmail.isEnabled = false
    }

    private fun isOtpView()
            : Boolean {
        return binding.tvotp.visibility == View.VISIBLE

    }

    private fun initPhone() {
        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (s?.length == 10) {
                  //  binding.etEmail.borderEnable()
                    if (!isOtpView()) {
                        binding.vBottom.deactive = false
                    }
                } else {
                //    binding.etEmail.borderDisable()
                    if (!isOtpView()) {
                        binding.vBottom.deactive = true
                    }
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun startTimer() {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.resend = "Resend Otp in 0:${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                binding.resend = null
                if (lifecycle.currentState == Lifecycle.State.RESUMED)
                    sendOtp()
            }


        }
        countDownTimer?.start()
    }

    override fun onBackPressed() {
        if (isOtpView()) {
            countDownTimer?.cancel()
            binding.resend = null
            hideOtpView()
        } else
            super.onBackPressed()
    }

    override fun onDestroy() {
        countDownTimer?.cancel()
        super.onDestroy()
    }
}