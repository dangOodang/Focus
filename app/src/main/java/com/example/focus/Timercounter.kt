package com.example.focus

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.timer.*
import org.jetbrains.anko.startActivity

class Timercounter : AppCompatActivity() {
    //    inner class ()
    private var fuck = ""
    private var age = 0L
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
            startActivity<timeendActivity>("name" to fuck, "time" to (ApplicationData.time_minute + age))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer)
        fuck = intent.getStringExtra("username").toString()
        age = intent.getIntExtra("age", 0).toLong()
        if(fuck.isEmpty() || fuck == "" || fuck == "null")
            theme1.text = "暂无标签"
        else
            theme1.text = fuck
        timerText.text = "1:00"
        var timer = MyCountDownTimer(1, 100)
        theme1.setOnClickListener {
            startActivity<ShowActivity>()
        }
        to_home.setOnClickListener {
            startActivity<BaobiaoActivity>()
        }
        mine.setOnClickListener {
            startActivity<myhome>()
        }
        playStop.setOnClickListener {
            if(fuck.isEmpty() || fuck == "" || fuck == "null") {
                Toast.makeText(applicationContext, "请选择一个标签", Toast.LENGTH_SHORT).show()
            }
            else {
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
        }

        time_select_button.setOnClickListener {
            if(fuck.isEmpty() || fuck == "" || fuck == "null")
            else
            {
                val newFragment = DurationPicker()
                newFragment.show(fragmentManager, "timePicker")
            }
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
