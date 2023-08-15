package com.projectbyzakaria.quizapp.data.cach

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

class DataStore {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_caches")


    companion object {
        private var dataStoreNullable : DataStore<Preferences>? = null
        fun getDataStore(context: Context): DataStore<Preferences> {
            return DataStore().run {
                dataStoreNullable?.let {store ->
                   return@run store
                }
                dataStoreNullable  = context.dataStore
                return@run context.dataStore
            }
        }

    }
}