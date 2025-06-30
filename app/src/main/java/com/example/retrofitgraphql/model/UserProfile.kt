package com.example.retrofitgraphql.model


data class UserGraphQLRequest(
    val query: String
)

data class UserGraphQLResponse<T>(
    val data: T?
)


data class UserProfileResponse(
    val getProfile: UserProfile
)

data class UserProfile(
    val id: String,
    val fullName: String,
    val phoneNumber: String,
    val username: String
)