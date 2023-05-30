package com.puneet.services2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.puneet.services2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var br = BroadcastExample()

    var count : Int = 0

    var userName:String? = null
    var details:String? = null
    var isChecked:Boolean? = null

    lateinit var sharedPreferences : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonCount.setOnClickListener{
            count+=1

            binding.buttonCount.setText(""+ count)  //Good way to convert int value into string
        }


        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.registerReceiver(br,filter)


        binding.serviceStart.setOnClickListener {
            val intent = Intent(this@MainActivity, ServiceClassExample::class.java)
            startService(intent)
        }

        binding.jobService.setOnClickListener {
            val intent = Intent(this@MainActivity, JobIntentServiceExample::class.java)
            JobIntentServiceExample.myBackgroundService(this, intent)
        }

        binding.serviceStop.setOnClickListener {
            val intent = Intent(this@MainActivity, ServiceClassExample::class.java)
            stopService(intent)
        }

        binding.frenchteacheractivity.setOnClickListener{
            val intent = Intent(this@MainActivity,FrenchTeacherApp::class.java)
            startActivity(intent)
        }

    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    fun saveData(){
        sharedPreferences = getSharedPreferences("saveData",Context.MODE_PRIVATE)
        userName = binding.editTextPersonName.text.toString()
        details = binding.editTextMultiLine.text.toString()
        isChecked = binding.checkBox.isChecked

        val editor = sharedPreferences.edit()
        editor.putString("key name",userName)
        editor.putString("key details",details)
        editor.putInt("key count",count)
        editor.putBoolean("key isChecked",isChecked!!)
        editor.apply()
    }


    override fun onResume() {
        super.onResume()
        retriveData()
    }

    fun retriveData(){
        sharedPreferences = getSharedPreferences("saveData",Context.MODE_PRIVATE)
        userName = sharedPreferences.getString("key name",null)
        details = sharedPreferences.getString("key details",null)
        count = sharedPreferences.getInt("key count",0)
        isChecked = sharedPreferences.getBoolean("key isChecked",false)

        binding.editTextPersonName.setText(userName)
        binding.editTextMultiLine.setText(details)
        binding.buttonCount.setText(""+count)
        binding.checkBox.isChecked = isChecked!!
    }
}