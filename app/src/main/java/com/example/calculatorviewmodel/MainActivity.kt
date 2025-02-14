package com.example.calculatorviewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.calculatorviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        displayResult()

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
                    viewModel.calculate(width, lenght, height)
                    displayResult()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }
}