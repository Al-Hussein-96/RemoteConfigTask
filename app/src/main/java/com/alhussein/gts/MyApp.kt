package com.alhussein.gts

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.text.TextUtils
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import java.util.*


@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()


        initThemeMode();
        initLanguage();

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    private fun initThemeMode() {
        when (getDarkMode()) {
            0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }


    fun updateLanguage(ctx: Context, lang: String?) {
        val cfg = Configuration()
        if (!TextUtils.isEmpty(lang)) cfg.locale = Locale(lang) else cfg.locale =
            Locale.getDefault()
        ctx.resources.updateConfiguration(cfg, null)
    }


    private fun initLanguage() {

        when (getLanguage()) {
            0 -> updateLanguage(this,"en")
            1 -> updateLanguage(this,"ar")
        }
    }


    fun saveDarkMode(dark_mode: Int) {
        val mSharedPreferences = getSharedPreferences("dark_mode", MODE_PRIVATE)
        val editor = mSharedPreferences.edit()
        editor.putInt("dark_mode", dark_mode)
        editor.commit()
    }

    fun getDarkMode(): Int {
        val mSharedPreferences = getSharedPreferences("dark_mode", MODE_PRIVATE)
            ?: return 0
        return mSharedPreferences.getInt("dark_mode", 0)
    }

    fun saveLanguage(lang: Int) {
        val mSharedPreferences = getSharedPreferences("language", MODE_PRIVATE)
        val editor = mSharedPreferences.edit()
        editor.putInt("lang", lang)
        editor.commit()
    }

    fun getLanguage(): Int {
        val mSharedPreferences = getSharedPreferences("language", MODE_PRIVATE)
            ?: return 0
        return mSharedPreferences.getInt("lang", 0)
    }

}