package com.alhussein.gts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.get
import com.alhussein.gts.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initSettings();




        binding.language.setOnCheckedChangeListener { group, checkedId ->
            saveSettings()
            checkLanguage()
        }
        binding.uiMode.setOnCheckedChangeListener { group, checkedId ->
            saveSettings()
            checkMode()
        }

    }
    private fun getLang(): String {
        return when ((application as MyApp).getLanguage()) {
            0 -> "en"
            1 -> "ar"
            else -> {
                "en"
            }
        }
    }
    private fun updateLanguage(lang: String) {
        (application as MyApp).updateLanguage(this, lang)
    }
    private fun checkMode() {
        if (binding.uiMode.checkedRadioButtonId == binding.dark.id) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun checkLanguage() {
        when (binding.language.checkedRadioButtonId) {
            binding.english.id -> (application as MyApp).updateLanguage(this, "en")
            binding.arabic.id -> (application as MyApp).updateLanguage(this, "ar")
        }
        startActivity(Intent(this, SplashActivity::class.java))
        finish()
    }


    private fun initSettings() {
        when ((application as MyApp).getDarkMode()) {
            0 -> binding.uiMode.check(binding.light.id)
            1 -> binding.uiMode.check(binding.dark.id)
        }

        when ((application as MyApp).getLanguage()) {
            0 -> binding.language.check(binding.english.id)
            1 -> binding.language.check(binding.arabic.id)
        }
    }

    private fun saveSettings() {
        val language = binding.language.checkedRadioButtonId
        val uiMode = binding.uiMode.checkedRadioButtonId


        when (uiMode) {
            binding.light.id -> (application as MyApp).saveDarkMode(0)
            binding.dark.id -> (application as MyApp).saveDarkMode(1)
        }

        when (language) {
            binding.english.id -> (application as MyApp).saveLanguage(0)
            binding.arabic.id -> (application as MyApp).saveLanguage(1)
        }


    }



}