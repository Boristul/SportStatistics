package com.sports.sportstatistics.repository.database.dao

import androidx.room.*
import com.sports.sportstatistics.repository.database.entity.Athlete

@Dao
interface AthleteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(account: Athlete)

    @Update
    suspend fun update(account: Athlete)

    @Query("SELECT * FROM athletes")
    suspend fun getAll(): List<Athlete>

    @Query("SELECT * FROM athletes WHERE name = :name LIMIT 1")
    suspend fun getByName(name: String): Athlete

    @Query("DELETE FROM athletes WHERE name = :name")
    suspend fun delete(name: String)

    @Query("DELETE FROM athletes WHERE name = :name AND age = :age")
    suspend fun delete(name: String, age: Int)
}
