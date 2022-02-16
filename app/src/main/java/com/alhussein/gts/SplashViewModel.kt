package com.alhussein.gts

import androidx.lifecycle.ViewModel
import com.alhussein.gts.data.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val firebaseRepository: FirebaseRepository) : ViewModel() {
    val lockAppFlow = firebaseRepository.lockAppFlow




}