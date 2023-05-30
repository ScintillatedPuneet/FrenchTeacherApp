package com.puneet.services2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BroadcastExample : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirplaneMode : Boolean = intent!!.getBooleanExtra("state",false)

        if(isAirplaneMode){
           Toast.makeText(context,"Device is on AirplaneMode",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context,"AirplaneMOde off",Toast.LENGTH_LONG).show()
        }
    }
}