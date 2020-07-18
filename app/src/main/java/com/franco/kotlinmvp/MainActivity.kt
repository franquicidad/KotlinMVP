package com.franco.kotlinmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.franco.kotlinmvp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() ,MainPresenter.View{
    private lateinit var binding:ActivityMainBinding

    private val presenter=MainPresenter(this,lifecycleScope)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding =ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        with(binding){
            validar.setOnClickListener(){
                presenter.onBottonClick(username.text.toString(),password.text.toString())
            }
        }

    }

    override fun setProgressVisible(boolean: Boolean) {
        binding.progressBar?.visibility=View.VISIBLE
    }

    override fun setMessage(message: String) {
        binding.resultadoOpAsync?.text=message
    }
}