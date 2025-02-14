package com.example.calculatorviewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener{
            val width = binding.edtWidth.text.toString()
            val lenght = binding.edtLenght.text.toString()
            val height = binding.edtHeight.text.toString()

            when{
                width.isEmpty()->{
                    binding.edtWidth.error = "Masih Kosong"
                }
                lenght.isEmpty()->{
                    binding.edtLenght.error = "Masih Kosong"
                }
                height.isEmpty()-> {
                    binding.edtHeight.error = "Masih Kosong"
                }
                else -> {
                    val result = width.toDouble() * lenght.toDouble() * height.toDouble()
                    binding.tvResult.text = result.toString()
                }
            }
        }
    }
}