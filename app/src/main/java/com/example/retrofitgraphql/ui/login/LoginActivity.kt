package com.example.retrofitgraphql.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitgraphql.databinding.ActivityLoginBinding
import com.example.retrofitgraphql.model.LoginRequestModel
import com.example.retrofitgraphql.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        onClickListener()

    }

    private fun onClickListener() {
        binding.Btnlogin.setOnClickListener {
            requestLogin()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    private fun requestLogin() {
        viewModel.getLoginRequest(
            context = this,
            requestModel = LoginRequestModel(
                phoneNumber = binding.etPhoneNumber.text.toString(),
                password = binding.etPassword.text.toString(),
                firebaseToken = "qwertyuijhgfddfghjklkjhg"
            )
        )

    }

    private fun handleResponse() {
        viewModel.login.observe(this) { login ->
            Log.e("TAG", "User Phone: ${login.login.user.phoneNumber}")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}
