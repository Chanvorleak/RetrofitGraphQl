package com.example.retrofitgraphql.api
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://api-dev.jalatlogistics.com/service-user/"

    private const val AUTH_TOKEN =
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjNiNzhhMzE2LWEyZmUtNDc3YS1hOTYwLTIxOWUwNGJhNzczOCIsInBob25lTnVtYmVyIjoiKzg1NTg3OTgyODg1IiwiZnVsbE5hbWUiOiJTaW0gTWVuZ2h1eS1SUy5QTCIsInVzZXJUeXBlIjoiRFJJVkVSIiwic3RhdHVzIjoiQUNUSVZFIiwicm9sZUlkIjpudWxsLCJsb2dpbkRhdGUiOiIyMDI1LTA2LTI1VDA3OjUzOjQyLjg1MloifQ.LofNAiV0-YIYvyoxQqFaq0Lfl6coMZtTm1xVe1jJLm4"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("x-platform", "android")
                .addHeader("x-udid", "123")
                .addHeader("Authorization", AUTH_TOKEN)
                .build()
            chain.proceed(request)
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val api: GraphQLApi = retrofit.create(GraphQLApi::class.java)
}
