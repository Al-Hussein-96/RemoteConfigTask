package com.alhussein.gts.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.alhussein.gts.data.model.ResultApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Singleton
class FirebaseRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val remoteConfig: FirebaseRemoteConfig
) {
    init {
        lockApp()
    }

    private val _lockAppFlow = MutableStateFlow<ResultApp>(ResultApp(false,""))
    val lockAppFlow = _lockAppFlow.asStateFlow()

    private fun lockApp() {

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 1
        }
        remoteConfig.setConfigSettingsAsync(configSettings)




        remoteConfig.fetchAndActivate()
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d("RemoteConfig", "Config params updated: $updated")
                } else {
                }
                val mode = remoteConfig["lock_app"].asBoolean()
                val message = remoteConfig["message"].asString()
                _lockAppFlow.value = (ResultApp(mode = mode, message = message))
            }


    }


}