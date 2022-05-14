package com.hend.services.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.hend.services.helper.NotificationHelper

class BackgroundService : Service() {
    private val TAG = "backgroundService"
    private val SERVICE_ID = 1
    private lateinit var helperNotification: NotificationHelper


    override fun onBind(intent: Intent): IBinder? = null
    override fun onCreate() {
        super.onCreate()

        Log.d(TAG,"onCreate")
        helperNotification = NotificationHelper(this)
        startForeground(1,helperNotification.getNotification())
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"onStart")
        showMessage()
        return START_STICKY
    }
    private fun showMessage(){
        Handler(Looper.getMainLooper()!!).postDelayed(
            {
              Toast.makeText(applicationContext,"from service",Toast.LENGTH_SHORT).show()
            },
            20000
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
}