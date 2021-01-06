package com.example.onboardingscreenwithlottieanimation

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import kotlinx.coroutines.flow.map

class DataStorePreference @Inject constructor(private val preferences: DataStore<Preferences>) {

    suspend fun saveOnboarding(save:Boolean) {
        preferences.edit {
            it[preferencesKey<Boolean>(ONBOARD_KEY)] = save
        }
    }

    fun fetchOnboarding() = preferences.data.map {
        it[preferencesKey<Boolean>(ONBOARD_KEY)] ?: false  }

    suspend fun saveDiet(diet:String){
        preferences.edit {
            it[preferencesKey<String>(DIET_KEY)] = diet
        }
    }

    fun fetchDiet() = preferences.data.map {
        it[preferencesKey<String>(DIET_KEY)]?:"vegetarian"
    }

    companion object{
        const val ONBOARD_KEY = "onBoard"
        const val DIET_KEY = "diet"
    }
}