package com.projectbyzakaria.quizapp.data.cach

import com.projectbyzakaria.quizapp.model.UserCache
import kotlinx.coroutines.flow.Flow

interface Caches {
    suspend fun getCurrentUserLevel(): Flow<UserCache>

    suspend fun setPaintsForLevelOne(paint: Int)

    suspend fun setPaintsForLevelTwo(paint: Int)

    suspend fun setPaintsForLevelTree(paint: Int)

    suspend fun setPaintsForLevelFour(paint: Int)

    suspend fun setPaintsForLevelFive(paint: Int)

    suspend fun setPaintsForLevelSex(paint: Int)

    suspend fun setPaintsForLevelSeven(paint: Int)

    suspend fun setPaintsForLevelEight(paint: Int)

    suspend fun setPaintsForLevelNine(paint: Int)

    suspend fun setPaintsForLevelTen(paint: Int)


}