package com.example.trabalho2bimestre

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.trabalho2bimestre.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide();
        window.statusBarColor = Color.parseColor("#FFFFFF");

        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, Home::class.java);
            startActivity(intent);
            finish();
        },5000);
    }


}