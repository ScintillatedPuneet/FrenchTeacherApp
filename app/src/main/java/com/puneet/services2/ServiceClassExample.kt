package com.puneet.services2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServiceClassExample : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Service","Classic Service is Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("Service","Classic Service is Start")
        Log.d("Service Thread",Thread.currentThread().name)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service","Classic Service is Stopped")
    }


}