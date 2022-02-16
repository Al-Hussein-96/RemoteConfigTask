package com.alhussein.gts

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.alhussein.gts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)


//        binding.btnSave.setOnClickListener {
//            saveSettingsAndRefresh();
//            refreshApp();
//        }
//
//        binding.uiMode.setOnCheckedChangeListener { group, checkedId ->
//            if (checkedId == binding.dark.id) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//
//            }
//        }


    }

    private fun saveSettingsAndRefresh() {
        var language = binding.language.checkedRadioButtonId
        var uiMode = binding.uiMode.checkedRadioButtonId

        var lang = (application as MyApp).getLanguage()
        var isDarkMode = (application as MyApp).isDarkMode()

//        val currentNightMode = configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
//        when (currentNightMode) {
//            Configuration.UI_MODE_NIGHT_NO -> {} // Night mode is not active, we're using the light theme
//            Configuration.UI_MODE_NIGHT_YES -> {} // Night mode is active, we're using dark theme
//        }


    }

    private fun refreshApp() {
        TODO("Not yet implemented")
    }


}