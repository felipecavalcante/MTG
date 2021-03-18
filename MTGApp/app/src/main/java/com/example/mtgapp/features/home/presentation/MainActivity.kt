package com.example.mtgapp.features.home.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mtgapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpObservers()

    }

    private fun setUpObservers(){

        binding.text.setOnClickListener{
            viewModel.fetchCards(binding.edit.text.toString())
        }
        viewModel.responseCardList.observe(this, {
            binding.text.text = it[0].name
        })
    }
}