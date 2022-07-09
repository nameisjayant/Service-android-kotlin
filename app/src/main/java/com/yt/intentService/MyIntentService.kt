package com.yt.intentService

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("my service") {

    init {
        instance = this
    }

    companion object{
        private lateinit var instance:MyIntentService
        var isRunning = false

        fun stopService(){
            Log.d("main", "service stopped.")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {
       try {
           isRunning = true
           while (isRunning){
               Log.d("main", "Service is running...")
           }
       }catch (e:InterruptedException){
           e.printStackTrace()
       }
    }
}