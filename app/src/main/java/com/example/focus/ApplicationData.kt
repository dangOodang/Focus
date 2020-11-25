package com.example.focus

import android.app.Application
import android.media.SoundPool

class ApplicationData: Application(){
    companion object {
        var time_minute: Long = 0L
        var time_second: Long = 0L
        lateinit var soundPool: SoundPool
        var soundResId = 0
        var isTimerCreate = true
    }
}