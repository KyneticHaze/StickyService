package com.example.stickyservice

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(view: View) {
        Intent(this, StickyService::class.java).also {
            startService(it)
        }
    }

    fun stop(view: View) {
        Intent(this, StickyService::class.java).also {
            stopService(it)
        }
    }
}