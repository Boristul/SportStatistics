package com.sports.sportstatistics.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sports.sportstatistics.repository.database.dao.AthleteDao
import com.sports.sportstatistics.repository.database.entity.Athlete

@Database(entities = [Athlete::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun athleteDao(): AthleteDao
}
