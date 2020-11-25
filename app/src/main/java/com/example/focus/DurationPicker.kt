 package com.example.focus

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Build
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.view.*
import android.view.LayoutInflater
import android.widget.*
import android.widget.NumberPicker
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.timer.view.*

 class DurationPicker : DialogFragment()  {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val activity = activity

        val inflater = LayoutInflater.from(this.context)
        val view = inflater.inflate(R.layout.fragment_durationpicker, null)

        val list = mutableListOf<String>()
        for (i in 0..60) {
            if (i < 10) {
                list.add("0" + i.toString())
            } else
                list.add(i.toString())
        }
        val list1 = mutableListOf<String>()
        for (i in 5..180) {
            if(i < 10)
                list1.add("0" + i.toString())
            else
                if(i < 100)
                    list1.add("0" + i.toString())
                else
                    list1.add(i.toString())
        }

        val numberPickerMin = view.findViewById<NumberPicker>(R.id.numPicker0)
        numberPickerMin.minValue = 5
        numberPickerMin.maxValue = 180
        numberPickerMin.displayedValues = list1.toTypedArray()

        val numberPickerSec = view.findViewById<NumberPicker>(R.id.numPicker1)
        numberPickerSec.minValue = 0
        numberPickerSec.maxValue = 60
        numberPickerSec.displayedValues = list.toTypedArray()

        val builder = AlertDialog.Builder(getActivity())

        val button_ok = view.findViewById<Button>(R.id.okbutton)
        val button_cancel = view.findViewById<Button>(R.id.cancelbutton)

        numberPickerMin.setOnValueChangedListener { _, _, newVal ->
            if (newVal == 180) {
                numberPickerMin.value = 5
                numberPickerMin.maxValue = 180
            } else
                if (numberPickerMin.getMaxValue() != 180) {
                    numberPickerMin.maxValue = 180
                }
        }


        button_ok.setOnClickListener {

            val tv: TextView = activity.findViewById(R.id.timerText) as TextView
            val bt = activity.findViewById(R.id.playStop) as com.google.android.material.floatingactionbutton.FloatingActionButton
            val minute = numberPickerMin.getValue()
            val second = numberPickerSec.getValue()

            tv.text = "%1$02d:%2$02d".format(minute, second)
            ApplicationData.time_minute = minute.toLong()
            ApplicationData.time_second = second.toLong()
            ApplicationData.isTimerCreate = true
            bt. playStop.setImageResource(
                    R.drawable.ic_play_circle_filled_black_24dp
            )
            this@DurationPicker.dismiss()
        }

        button_cancel.setOnClickListener {
            Toast.makeText(activity, "请设置时间", Toast.LENGTH_SHORT).show()
            this@DurationPicker.dismiss()
        }

        builder.setView(view)
        return builder.create()
    }
}