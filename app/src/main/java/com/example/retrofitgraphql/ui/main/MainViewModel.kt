package com.example.retrofitgraphql.ui.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.retrofitgraphql.api.RetrofitClient
import com.example.retrofitgraphql.model.LogoutGraphQlRequest
import com.example.retrofitgraphql.model.LogoutGraphQlResponse
import com.example.retrofitgraphql.preference.UserSession
import com.example.retrofitgraphql.ui.login.LoginActivity
import com.example.retrofitgraphql.ui.user.UserProfileActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.jvm.java

class MainViewModel : ViewModel() {

    fun logout(context: Context) {
        val query = "mutation{" +
                "logout" +
                "}"

        val request = LogoutGraphQlRequest(query)

        RetrofitClient.getApi(context).logoutUser(request)
            .enqueue(object : Callback<LogoutGraphQlResponse<Boolean>> {
                override fun onResponse(
                    call: Call<LogoutGraphQlResponse<Boolean>>,
                    response: Response<LogoutGraphQlResponse<Boolean>>
                ) {
                    if (response.isSuccessful && response.body()?.data == true) {
                        UserSession(context).clearData()
                        val intent = Intent(context, LoginActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        context.startActivity(intent)
                        if (context is Activity) {
                            context.finish()
                        }
                    } else {
                        Log.e("Logout", "Failed to logout: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<LogoutGraphQlResponse<Boolean>>, t: Throwable) {
                    Log.e("Logout", "Logout failed: ${t.message}")
                }
            })
    }
}
