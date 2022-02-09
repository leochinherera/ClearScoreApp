package com.app.remote.repository

import androidx.lifecycle.LiveData
import com.app.remote.data.NetworkDataSource
import com.app.remote.data.network_data.CreditResponse


import com.app.remote.Datanterface
import com.app.remote.NetworkState
import io.reactivex.disposables.CompositeDisposable

class Repository (private val apiService : Datanterface) {

    lateinit var NetworkDataSource: NetworkDataSource

    fun fetchSingledonutDetails (compositeDisposable: CompositeDisposable) : LiveData<CreditResponse> {

        NetworkDataSource = NetworkDataSource(apiService,compositeDisposable)
        NetworkDataSource.fetchdonutDetails()

        return NetworkDataSource.downloadedImageResponse

    }

    fun getdonutDetailsNetworkState(): LiveData<NetworkState> {
        return NetworkDataSource.networkState
    }



}