package com.example.retrofitgraphql.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitgraphql.databinding.ActivityMainBinding
import com.example.retrofitgraphql.ui.tagProduct.TagProductionActivity
import com.example.retrofitgraphql.ui.user.UserProfileActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetUser.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnGetProductionName.setOnClickListener {
            val intent = Intent(this, TagProductionActivity::class.java)
            startActivity(intent)
        }
    }
}