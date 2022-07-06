package com.rk.riggle_retailer.ui.main.orders

import com.rk.riggle_retailer.data.api.ApiHelper
import com.rk.riggle_retailer.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrdersFragmentVM @Inject constructor(private val apiHelper: ApiHelper) : BaseViewModel() {

   // var obrRetailerList = SingleRequestEvent<List<RetailerDetails>>()

    /*fun getRetailerList(authorization: String, queryString: String) {
        val query = HashMap<String, String>()
        query["search"] = queryString
        Coroutines.io {
            obrRetailerList.postValue(Resource.loading(null))
            try {
                apiHelper.searchRetailers(authorization, query).let {
                    if (it.isSuccessful) {
                        it.body()?.results?.let { results ->
                            obrRetailerList.postValue(Resource.success(results, "Success"))
                        }
                    } else {
                        obrRetailerList.postValue(Resource.warn(null, it.message()))
                    }
                }
            } catch (e: Exception) {
                parseException(e.cause)?.let {
                    obrRetailerList.postValue(Resource.error(null, it))
                }
            }
        }
    }*/
}