package com.app.clearscoreapp.donut_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.app.remote.NetworkState
import com.app.remote.data.network_data.CreditResponse
import com.app.remote.repository.Repository

import io.reactivex.disposables.CompositeDisposable

class DonutViewModel (private val donutRepository : Repository)  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
//get the donut detail from the response
    val  donutDetails : LiveData<CreditResponse> by lazy {
        donutRepository.fetchSingledonutDetails(compositeDisposable)
    }

    val networkState : LiveData<NetworkState> by lazy {
        donutRepository.getdonutDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}