package com.ritesh.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ritesh.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel= ViewModelProvider(this).get(MainActivity::class.java)

        mainViewModel.quoteLiveData.observe(this, Observer {
            binding.textTv.text= it
        })
        binding.buttonUpdate.setOnClickListener{
            mainViewModel.updateQuote()
        }
    }
}