package com.app.remote

import com.app.remote.data.network_data.CreditResponse
import io.reactivex.Single
import retrofit2.http.GET
interface Datanterface {
//endpoint of the base url
    @GET("endpoint.json")
    fun getScore(): Single<CreditResponse>
}