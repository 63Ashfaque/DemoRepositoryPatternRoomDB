package com.example.demorepositorypatternroomdb.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moviesTable")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val director: String
)