package com.app.remote.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.remote.data.network_data.CreditResponse
import com.app.remote.Datanterface

import com.app.remote.NetworkState

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers



class NetworkDataSource (private val apiService : Datanterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState   //with this get, no need to implement get function to get networkSate

    private val _downloadeddonutDetailsResponse =  MutableLiveData<CreditResponse>()
    val downloadedImageResponse: LiveData<CreditResponse>
        get() = _downloadeddonutDetailsResponse

    fun fetchdonutDetails() {

        _networkState.postValue(NetworkState.LOADING)


        try {

            compositeDisposable.add(
                apiService.getScore()//get score on the repository
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadeddonutDetailsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)

                        }
                    )
            )

        }

        catch (e: Exception){

        }


    }
}