package com.example.trabalho2bimestre

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.trabalho2bimestre.databinding.ActivityIntegrantesBinding

class Integrantes : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityIntegrantesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntegrantesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var exitButton = binding.exitIntegrantes;

        exitButton.setOnClickListener({
            finish();
        })

    }

}