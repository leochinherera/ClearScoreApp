package com.app.remote.data.network_data


import com.google.gson.annotations.SerializedName

data class CoachingSummary(
    @SerializedName("activeChat")
    val activeChat: Boolean,
    @SerializedName("activeTodo")
    val activeTodo: Boolean,
    @SerializedName("numberOfCompletedTodoItems")
    val numberOfCompletedTodoItems: Int,
    @SerializedName("numberOfTodoItems")
    val numberOfTodoItems: Int,
    @SerializedName("selected")
    val selected: Boolean
)