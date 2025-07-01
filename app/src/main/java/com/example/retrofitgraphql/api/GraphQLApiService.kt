package com.example.retrofitgraphql.api


import com.example.retrofitgraphql.model.LoginGraphQlRequest
import com.example.retrofitgraphql.model.LogoutGraphQlRequest
import com.example.retrofitgraphql.model.LoginGraphQlResponse
import com.example.retrofitgraphql.model.LoginResponse
import com.example.retrofitgraphql.model.LogoutGraphQlResponse
import com.example.retrofitgraphql.model.TagGraphQLRequest
import com.example.retrofitgraphql.model.TagGraphQLResponse
import com.example.retrofitgraphql.model.TagProductionResponse
import com.example.retrofitgraphql.model.UserGraphQLRequest
import com.example.retrofitgraphql.model.UserGraphQLResponse
import com.example.retrofitgraphql.model.UserProfileResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface GraphQLApiService {

    @POST("v1")
    fun fetchUserProfile(
        @Body request: UserGraphQLRequest
    ): Call<UserGraphQLResponse<UserProfileResponse>>

    @POST("v1")
    fun fetchProductionTag(
        @Body request: TagGraphQLRequest
    ): Call<TagGraphQLResponse<TagProductionResponse>>

    @POST("v1")
    fun postData(
        @Body request: LoginGraphQlRequest
    ): Call<LoginGraphQlResponse<LoginResponse>>


    @POST("v1")
    fun logoutUser(
        @Body request: LogoutGraphQlRequest
    ): Call<LogoutGraphQlResponse<Boolean>>
}


