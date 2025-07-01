package com.example.retrofitgraphql.model


data class LoginGraphQlRequest(
    val query: String
)

data class LoginGraphQlResponse<T>(
    val data: T?
)

data class LoginResponse(
    val login: Login
)

data class Login(
    val token: String,
    val user: User
)
data class User(
    val username: String,
    val phoneNumber: String
)

data class LoginRequestModel(
    val password: String,
    val phoneNumber: String,
    val firebaseToken: String
)

