package com.splicer.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.splicer.countdowntimer.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            bStart.setOnClickListener {
startCountDownTimer(1000)
            }
        }
    }

    private fun startCountDownTimer(timeMilLis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMilLis, 1) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = millisUntilFinished.toString()
            }

            override fun onFinish() {
                binding.tvTimer.text = "Finish"
            }

        }.start()
    }
}