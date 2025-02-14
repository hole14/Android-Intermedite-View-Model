package com.example.calculatorviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorviewmodel.databinding.ActivityFotoBinding

class FotoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFotoBinding
    private lateinit var viewModel: FotoViewModel
    private lateinit var poto: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(FotoViewModel::class.java)

        poto = binding.recyclerPoto
        poto.setHasFixedSize(true)
        poto.layoutManager = GridLayoutManager(this,2)

        val fotoList = tampil()

        val adapter = AdapterFoto(fotoList)
        poto.adapter = adapter

    }

    private fun tampil(): MutableList<foto> {
        val dataFoto = resources.obtainTypedArray(R.array.data_poto)
        val list = mutableListOf<foto>()

        for (i in 0 until dataFoto.length()){
            val foto = foto(dataFoto.getResourceId(i, -1))
            list.add(foto)
        }
        dataFoto.recycle()
        return list
    }
}

