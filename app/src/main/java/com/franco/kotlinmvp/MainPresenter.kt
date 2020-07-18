package com.franco.kotlinmvp

import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(private val view:View,private val scope:CoroutineScope){

    interface View{
        fun setProgressVisible(boolean: Boolean)
        fun setMessage(message:String)
        }
    fun onBottonClick(user:String,pass:String){
        scope.launch(){
            view.setProgressVisible(true)
            view.setMessage(withContext(Dispatchers.IO){
                Thread.sleep(2000)
                if(user.isNotEmpty()||pass.isNotEmpty())"Success" else "Failure"
            })
            view.setProgressVisible(false)


        }
    }


}