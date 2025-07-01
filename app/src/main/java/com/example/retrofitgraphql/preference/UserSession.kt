package com.example.retrofitgraphql.preference

import android.content.Context
import android.provider.Settings
import com.example.retrofitgraphql.base.BasePreference


class UserSession(context: Context) : BasePreference(context, "userSession") {

    companion object {
        private const val SPEED = "SPEED"
        private var instanceUserSession: com.example.retrofitgraphql.preference.UserSession? =
            null

        fun getInstance(context: Context): com.example.retrofitgraphql.preference.UserSession {
            if (instanceUserSession == null)
                instanceUserSession = UserSession(context)
            return instanceUserSession!!
        }
    }

    init {
        save(
            "deviceUniqueId",
            Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        )
    }

    fun speed(value: Float) = save(SPEED, value)
    fun speed(): Float = get(SPEED, 1f)
    fun deviceUniqueId() = get("deviceUniqueId", "")

    fun token(value: String) = save("TOKEN", value)

    fun token(): String = get("TOKEN", "").toString()

    fun user(value: String) = save("USER", value)

    fun user() = get("USER", "").toString()

    fun clearData() {
        token("")
        user("")
    }
}
// another way to do it
//class TokenManager(context: Context) {
//    private val prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
//
//    fun saveToken(token: String) {
//        prefs.edit().putString("auth_token", token).apply()
//    }
//
//    fun getToken(): String? {
//        return prefs.getString("auth_token", null)
//    }
//
//    fun clearToken() {
//        prefs.edit().remove("auth_token").apply()
//    }
//}
