package com.example.demorepositorypatternroomdb.repository

import com.example.demorepositorypatternroomdb.roomdb.MovieEntity

interface MovieRepository {
    suspend fun getAllMovies(): List<MovieEntity>
    fun getMovieById(id: Int): MovieEntity?
    suspend fun addMovie(movie: MovieEntity):Long
    suspend fun updateMovie(movie: MovieEntity)
    suspend fun deleteMovie(id: Int)
}