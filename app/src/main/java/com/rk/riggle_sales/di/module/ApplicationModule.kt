package com.rk.riggle_sales.di.module

import com.rk.riggle_sales.BuildConfig
import com.rk.riggle_sales.data.api.ApiHelper
import com.rk.riggle_sales.data.api.ApiHelperImpl
import com.rk.riggle_sales.data.api.ApiService
import com.rk.riggle_sales.data.place_api.PlaceApiHelper
import com.rk.riggle_sales.data.place_api.PlaceApiHelperImpl
import com.rk.riggle_sales.data.place_api.PlaceApiService
import com.rk.riggle_sales.data.qualifier.ApiPlaceEndPoint
import com.rk.riggle_sales.utils.ConstantData
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            /*.addInterceptor(BasicAuthInterceptor(Constants.USERNAME, Constants.PASSWORD))*/
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

    @ApiPlaceEndPoint
    @Singleton
    @Provides
    fun placeEndpoint() = ConstantData.GOOGLE_URL

    @ApiPlaceEndPoint
    @Singleton
    @Provides
    fun provideRetrofit2(
        @ApiPlaceEndPoint apiEndpoint: String?,
        okHttpClient: OkHttpClient?
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(apiEndpoint)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService2(@ApiPlaceEndPoint retrofit: Retrofit): PlaceApiService =
        retrofit.create(PlaceApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper2(apiHelper: PlaceApiHelperImpl): PlaceApiHelper = apiHelper

}