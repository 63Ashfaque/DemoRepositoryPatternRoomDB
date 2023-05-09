package com.example.demorepositorypatternroomdb.roomdb

import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM moviesTable")
    fun getAllMovies(): List<MovieEntity>

    @Query("SELECT * FROM moviesTable WHERE id = :id")
    fun getMovieById(id: Int): MovieEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity):Long

    @Update
    fun update(movie: MovieEntity)

    @Query("DELETE FROM moviesTable WHERE id = :id")
    fun delete(id: Int)

}