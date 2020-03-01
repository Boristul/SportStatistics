package com.sports.sportstatistics

import android.app.Application
import androidx.room.Room
import com.sports.sportstatistics.repository.database.AppDatabase


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
    }

    companion object {
        lateinit var instance: Application
        lateinit var database: AppDatabase
    }
}
