package com.sports.sportstatistics

import android.app.Application
import androidx.room.Room
import com.sports.sportstatistics.repository.database.AppDatabase
import com.sports.sportstatistics.repository.network.api.AthletesApi
import com.sports.sportstatistics.repository.network.api.serializer.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
        api = Retrofit.Builder()
            .baseUrl("https://www.balldontlie.io/")
            .client(
                OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(
                Json(JsonConfiguration.Stable.copy(strictMode = false)).asConverterFactory(
                    MediaType.get("application/json; charset=utf-8")
                )
            )
            .build()
            .create(AthletesApi::class.java)
    }

    companion object {
        lateinit var instance: Application
        lateinit var database: AppDatabase
        lateinit var api: AthletesApi
    }
}
