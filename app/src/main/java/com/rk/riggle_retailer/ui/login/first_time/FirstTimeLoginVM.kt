package com.rk.riggle_retailer.ui.login.first_time

import android.util.Log
import androidx.databinding.ObservableField
import com.google.gson.JsonElement
import com.rk.riggle_retailer.data.api.ApiHelper
import com.rk.riggle_retailer.data.model.User
import com.rk.riggle_retailer.ui.base.BaseViewModel
import com.rk.riggle_retailer.utils.event.SingleRequestEvent
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class FirstTimeLoginVM @Inject constructor(
    private val apiHelper: ApiHelper
) : BaseViewModel() {

    val obrGetOtp = SingleRequestEvent<JsonElement>()
    var obrVerifyOtp = SingleRequestEvent<User>()


    val field_otp = ObservableField<String>()
    val field_phone = ObservableField<String>()
/*

    fun getOtp(body: SendOtpBean) {
        obrGetOtp.value = Resource.loading(null)
        Coroutines.io {
            try {
                val response = apiHelper.getOtp(body)
                if (response.code() == 200) {
                    obrGetOtp.postValue(Resource.success(response.body(), response.message()))
                    Log.i("Success", response.body().toString())
                } else {
                    obrGetOtp.postValue(Resource.warn(response.body(), response.message()))
                    Log.i("Error", response.body().toString())
                }

            } catch (e: Exception) {
                e.printStackTrace()
                obrGetOtp.postValue(Resource.error(null, e.message.toString()))
                Log.i("Error", e.message.toString())
            }

        }

    }

    fun verifyOtp(body: VerifyOtp) {
        obrVerifyOtp.value = Resource.loading(null)
        Coroutines.io {
            try {
                val response = apiHelper.verifyOtp(body)
                if (response.code() == 200) {
                    obrVerifyOtp.postValue(
                        Resource.success(
                            response.body()?.user,
                            response.message()
                        )
                    )
                    response.body()?.session_id?.let {
                        SharedPrefManager.saveToken(it)
                    }
                    response.body()?.user?.let {
                        SharedPrefManager.saveUser(it)
                    }

                } else {
                    obrVerifyOtp.postValue(Resource.warn(null, response.message()))
                    Log.i("Error", response.body().toString())
                }

            } catch (e: Exception) {
                e.printStackTrace()
                obrVerifyOtp.postValue(Resource.error(null, e.message.toString()))
                Log.i("Error", e.message.toString())
            }

        }
    }


    private fun ping() {
        Coroutines.io {
            try {
                val response = apiHelper.ping()
                if (response.code() == 200) {
                    Log.i("Success", response.body().toString())
                    // SharedPrefManager.saveToken(response.body()?.get("session_id").toString())
                } else {
                    Log.i("Error", response.body().toString())
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.i("Error", e.message.toString())
            }

        }
    }
*/

}