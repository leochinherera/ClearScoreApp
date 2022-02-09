package com.app.remote.data.network_data


import com.google.gson.annotations.SerializedName

data class CreditResponse(
    @SerializedName("accountIDVStatus")
    val accountIDVStatus: String,
    @SerializedName("augmentedCreditScore")
    val augmentedCreditScore: Any,
    @SerializedName("coachingSummary")
    val coachingSummary: CoachingSummary,
    @SerializedName("creditReportInfo")
    val creditReportInfo: CreditReportInfo,
    @SerializedName("dashboardStatus")
    val dashboardStatus: String,
    @SerializedName("personaType")
    val personaType: String
)