package com.example.focus

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.timer.*
import org.jetbrains.anko.startActivity

class Timercounter : AppCompatActivity() {
    //    inner class ()
    inner class MyCountDownTimer(millisInFuture: Long, countDownInterval: Long) :
            CountDownTimer(millisInFuture, countDownInterval) {
        
        var isRunning = false
        var Last_set = 0L
        @SuppressLint("SetTextI18n")
        override fun onTick(millisUntilFinished: Long) {
            val minute = millisUntilFinished / 1000L / 60L
            val second = millisUntilFinished / 1000L % 60L
            timerText.text = "%d:%2$02d".format(minute, second)
        }

        @SuppressLint("SetTextI18n")
        override fun onFinish() {
            timerText.text = "complete!"
            ApplicationData.soundPool.play(ApplicationData.soundResId, 1.0f, 100f, 0, 0, 1.0f)

            ApplicationData.isTimerCreate = true
            playStop.setImageResource(
                    R.drawable.ic_play_circle_filled_black_24dp
            )
            //ApplicationData.soundResId = ApplicationData.soundPool.load(this@MainActivity, R.raw.bellsound, 1)
            ApplicationData.soundResId = ApplicationData.soundPool.load(this@Timercounter, R.raw.shock5, 1)
            startActivity<timeendActivity>("name" to "fuck", "time" to ApplicationData.time_minute)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer)

        timerText.text = "5:00"
        var timer = MyCountDownTimer(1, 100)
        playStop.setOnClickListener {
            if (ApplicationData.isTimerCreate) {
                val millisInFuture = ((ApplicationData.time_minute * 60L) + ApplicationData.time_second) * 1000L
                timer.Last_set = ApplicationData.time_minute
                timer = MyCountDownTimer(millisInFuture, 100)
            }
            when (timer.isRunning) {
                true -> timer.apply {
                    isRunning = false
                    cancel()
                    playStop.setImageResource(
                            R.drawable.ic_play_circle_filled_black_24dp
                    )
                    timerText.text = "%d:%2$02d".format(ApplicationData.time_minute, ApplicationData.time_second)
                }
                false -> timer.apply {
                    isRunning = true
                    ApplicationData.isTimerCreate = false
                    start()
                    playStop.setImageResource(
                            R.drawable.ic_stop_black_24dp
                    )
                }
            }
        }

        time_select_button.setOnClickListener {
            val newFragment = DurationPicker()
            newFragment.show(fragmentManager, "timePicker")
        }
    }

    override fun onResume() {
        super.onResume()
        ApplicationData.soundPool = SoundPool(2, AudioManager.STREAM_ALARM, 0)
        //ApplicationData.soundResId = ApplicationData.soundPool.load(this, R.raw.bellsound, 1)
        ApplicationData.soundResId = ApplicationData.soundPool.load(this, R.raw.shock5, 1)
    }

    override fun onPause() {
        super.onPause()
        ApplicationData.soundPool.release()
    }
}