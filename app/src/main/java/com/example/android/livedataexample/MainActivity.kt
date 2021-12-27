package com.example.android.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.livedataexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DataViewModel
    private lateinit var viewModelFactory: DataViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = DataViewModelFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DataViewModel::class.java)

        viewModel.totalCount.observe(this, Observer {
            binding.texto.text = it.toString()
        })
        binding.button.setOnClickListener{
            viewModel.addCount(1)
        }
    }
}