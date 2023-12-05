package com.example.stickyservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class StickyService : Service() {

    private lateinit var mediaPlayer : MediaPlayer
    
    companion object {
        private const val TAG = "StickyService"
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(applicationContext, Settings.System.DEFAULT_ALARM_ALERT_URI)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        Log.d(TAG, "onStartCommand: ")
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }
}