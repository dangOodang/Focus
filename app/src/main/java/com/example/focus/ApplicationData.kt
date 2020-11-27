package com.example.focus

import android.app.Application
import android.media.SoundPool

class ApplicationData: Application(){
    companion object {
        var time_minute: Int = 1
        var time_second: Int = 0
        lateinit var soundPool: SoundPool
        var soundResId = 0
        var isTimerCreate = true
    }
}