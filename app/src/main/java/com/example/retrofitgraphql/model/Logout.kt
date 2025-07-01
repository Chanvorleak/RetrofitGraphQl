package com.example.retrofitgraphql.model

data class LogoutGraphQlRequest(
    val query: String
)

data class LogoutGraphQlResponse<T>(
   val data: T?)