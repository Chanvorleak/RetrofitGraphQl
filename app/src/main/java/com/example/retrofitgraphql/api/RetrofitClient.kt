package com.example.retrofitgraphql.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitClient {

    private const val BASE_URL = "https://api-dev.jalatlogistics.com/service-user/"
    private var retrofit: Retrofit? = null

    fun getApi(context: Context): GraphQLApiService {
        if (retrofit == null) {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor(context))
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

        return retrofit!!.create(GraphQLApiService::class.java)
    }
}

//object RetrofitClient {
//
//    private const val BASE_URL = "https://api-dev.jalatlogistics.com/service-user/"
//
////    private const val AUTH_TOKEN =
////        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImRkOGIyOTkwLWUzNGEtNDhiZS04MmVkLTk4OTFmOTRjNDVlNiIsInBob25lTnVtYmVyIjoiKzg1NTk2MzcxOTQ3NyIsImZ1bGxOYW1lIjoiZ2xpbW1lciIsInVzZXJUeXBlIjoiTk9OX1BBUlRORVIiLCJzdGF0dXMiOiJBQ1RJVkUiLCJyb2xlSWQiOm51bGwsImxvZ2luRGF0ZSI6IjIwMjUtMDYtMzBUMDI6NTM6NTcuOTA5WiJ9.muVm9ZAGBRuOrK-fw91Ro99dQwR8xqTLGi5TE70ek3Q"
//
//    private val okHttpClient= OkHttpClient.Builder()
//        .addInterceptor(AuthInterceptor(context))
////        .addInterceptor(Interceptor { chain ->
////            val request = chain.request().newBuilder()
////                .addHeader("Content-Type", "application/json")
////                .addHeader("x-platform", "android")
////                .addHeader("x-udid", "123")
////                .addHeader("Authorization", "Bearer ${UserSession.token()}")
//        .build()
//
//private val retrofit = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .client(okHttpClient)
//    .build()
//
//val api: GraphQLApiService = retrofit.create(GraphQLApiService::class.java)
//}
