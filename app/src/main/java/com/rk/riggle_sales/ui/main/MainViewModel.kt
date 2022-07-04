package com.rk_tech.riggle_runner.ui.main.main

import androidx.lifecycle.*
import com.amazonaws.auth.policy.Resource
import com.rk.riggle_sales.data.api.ApiHelper

import com.rk.riggle_sales.ui.base.BaseViewModel
import com.rk.riggle_sales.utils.connectivity.ConnectivityProvider

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiHelper: ApiHelper

) : BaseViewModel() {

    private val _users = MutableLiveData<Resource>()
 //   val users: LiveData<Resource<List<User>>>


    init {
        fetchUsers()
    }

    private fun fetchUsers() {
     // connectivityProvider.getNetworkState().hasInternet()

       /* viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }*/
    }
}