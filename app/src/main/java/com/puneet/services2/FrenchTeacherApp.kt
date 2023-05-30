package com.puneet.services2

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.puneet.services2.databinding.ActivityFrenchTeacherAppBinding
import com.puneet.services2.databinding.ActivityMain2Binding

class FrenchTeacherApp : AppCompatActivity() {

    lateinit var binding:ActivityFrenchTeacherAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFrenchTeacherAppBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

   public fun onClickPronounce(view: View){
        val button : Button = view as Button

       var mediaPlayer:MediaPlayer = MediaPlayer.create(
           this,resources.getIdentifier(button.tag.toString(),"raw",packageName)
       )
       mediaPlayer.start()
    }

}