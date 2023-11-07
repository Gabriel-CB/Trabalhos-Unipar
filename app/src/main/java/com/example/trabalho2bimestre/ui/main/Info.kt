package com.example.trabalho2bimestre.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.trabalho2bimestre.R
import com.example.trabalho2bimestre.databinding.ActivityInfoBinding

class Info : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.name.setText(intent.getStringExtra("name").toString());
        binding.ra.setText(intent.getStringExtra("ra").toString());
        binding.curso.setText(intent.getStringExtra("curso").toString());

        binding.exitInfo.setOnClickListener({
            finish();
        })

    }

    override fun onDestroy() {
        super.onDestroy()

        finish();
    }
}