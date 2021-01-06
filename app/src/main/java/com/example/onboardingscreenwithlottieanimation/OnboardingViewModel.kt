package com.example.onboardingscreenwithlottieanimation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class OnboardingViewModel @ViewModelInject constructor(private val preference: DataStorePreference) :
    ViewModel() {


    fun saveOnboarding(save: Boolean) {
        viewModelScope.launch {
            preference.saveOnboarding(save)
        }
    }

    fun fetchOnboarding() = preference.fetchOnboarding().asLiveData()
}