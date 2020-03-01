package com.sports.sportstatistics.repository.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "athletes",
    indices = [Index("id")]
)
data class Athlete(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "age")
    val age: Int,

    @ColumnInfo(name = "height")
    val height: Double? = 0.0,

    @ColumnInfo(name = "weight")
    val weight: Double? = 0.0,

    @ColumnInfo(name = "sportType")
    val sportType: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long = getId(
        name,
        age,
        sportType
    )
) : Parcelable {
    companion object {
        fun getId(name: String?, age: Int?, sportType: String?): Long =
            (name.hashCode() + age.hashCode() + sportType.hashCode()).toLong()
    }
}
