package com.sports.sportstatistics

import android.app.Application
import androidx.room.Room
import com.sports.sportstatistics.repository.database.DataBase
import com.sports.sportstatistics.repository.network.api.AthletesApi
import com.sports.sportstatistics.repository.network.api.serializer.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class MainApplication : Application() {

    companion object {
        lateinit var instance: Application
        lateinit var database: DataBase
        lateinit var api: AthletesApi

        private const val RETROFIT_TIMEOUT = 30L
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, DataBase::class.java, "database")
            .build()
        api = Retrofit.Builder()
            .baseUrl("https://www.balldontlie.io/")
            .client(
                OkHttpClient.Builder()
                    .readTimeout(RETROFIT_TIMEOUT, TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(
                Json(JsonConfiguration.Stable.copy()).asConverterFactory(
                    MediaType.get("application/json; charset=utf-8")
                )
            )
            .build()
            .create(AthletesApi::class.java)
    }
}
