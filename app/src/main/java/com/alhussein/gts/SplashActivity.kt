package com.alhussein.gts

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alhussein.gts.data.model.ResultApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                lifecycleScope.launch {
                    val resultApp = splashViewModel.lockAppFlow.value
                    checkMaintenanceMode(resultApp)
                }

            }
        }
        timer.start()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    splashViewModel.lockAppFlow.collect()
                }
            }
        }


    }

    private fun checkMaintenanceMode(resultApp: ResultApp) {
        if (resultApp.mode) {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.banner_view);
            dialog.setTitle("Sorry");
            dialog.setCancelable(false)

            val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.35).toInt()

            dialog.window?.setLayout(width, height)

            dialog.findViewById<TextView>(R.id.text).text = resultApp.message

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.show()


        } else {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }


    }
}