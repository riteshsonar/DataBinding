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
        mainViewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        val quoteObj= Quote("Do, or do not. There is no try.","Yoda")
        binding.quote= quoteObj
        /*mainViewModel.quoteLiveData.observe(this, Observer {
            binding.quoteTv.text= it
        })*/
       /* binding.buttonUpdate.setOnClickListener{
            mainViewModel.updateQuote()
        }*/
    }
}