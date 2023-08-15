package com.projectbyzakaria.quizapp.data.cach

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.projectbyzakaria.quizapp.model.UserCache
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserCache(context: Context) : Caches {
    private val dataStore = DataStore.getDataStore(context)


    private val level1Key = intPreferencesKey("level1")
    private val level2Key = intPreferencesKey("level2")
    private val level3Key = intPreferencesKey("level3")
    private val level4Key = intPreferencesKey("level4")
    private val level5Key = intPreferencesKey("level5")
    private val level6Key = intPreferencesKey("level6")
    private val level7Key = intPreferencesKey("level7")
    private val level8Key = intPreferencesKey("level8")
    private val level9Key = intPreferencesKey("level9")
    private val level10Key = intPreferencesKey("level10")
    private val currentLevelKey = intPreferencesKey("current")


    override suspend fun setCurrentUserLevel(level: Int) {
        dataStore.edit {
            it[currentLevelKey] = level
        }
    }
    override suspend fun getCurrentUserLevel(): Flow<UserCache> {
        return dataStore.data.map {
            val paints = listOf(
                it[level1Key],
                it[level2Key],
                it[level3Key],
                it[level4Key],
                it[level5Key],
                it[level6Key],
                it[level7Key],
                it[level8Key],
                it[level9Key],
                it[level10Key]
            )
            UserCache(
                currentLevel = it[currentLevelKey] ?: 1,
                paints = paints
            )
        }
    }
    override suspend fun setPaintsForLevelOne(paint: Int) {
        dataStore.edit {
            it[level1Key] = paint
        }
    }

    override suspend fun setPaintsForLevelTwo(paint: Int) {
        dataStore.edit {
            it[level2Key] = paint
        }
    }

    override suspend fun setPaintsForLevelTree(paint: Int) {
        dataStore.edit {
            it[level3Key] = paint
        }
    }

    override suspend fun setPaintsForLevelFour(paint: Int) {
        dataStore.edit {
            it[level4Key] = paint
        }
    }

    override suspend fun setPaintsForLevelFive(paint: Int) {
        dataStore.edit {
            it[level5Key] = paint
        }
    }

    override suspend fun setPaintsForLevelSex(paint: Int) {
        dataStore.edit {
            it[level6Key] = paint
        }
    }

    override suspend fun setPaintsForLevelSeven(paint: Int) {
        dataStore.edit {
            it[level7Key] = paint
        }
    }

    override suspend fun setPaintsForLevelEight(paint: Int) {
        dataStore.edit {
            it[level8Key] = paint
        }
    }

    override suspend fun setPaintsForLevelNine(paint: Int) {
        dataStore.edit {
            it[level9Key] = paint
        }
    }

    override suspend fun setPaintsForLevelTen(paint: Int) {
        dataStore.edit {
            it[level10Key] = paint
        }
    }


}