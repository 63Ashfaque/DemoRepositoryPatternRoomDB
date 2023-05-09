package com.example.demorepositorypatternroomdb.repository

import com.example.demorepositorypatternroomdb.roomdb.MovieDao
import com.example.demorepositorypatternroomdb.roomdb.MovieEntity

class RoomMovieRepository(private val movieDao: MovieDao) : MovieRepository {


    override suspend fun getAllMovies(): List<MovieEntity> {
        return movieDao.getAllMovies().map { MovieEntity(it.id, it.title, it.director) }
    }

    override fun getMovieById(id: Int): MovieEntity? {
        val movieEntity = movieDao.getMovieById(id)
        return if (movieEntity != null) {
            MovieEntity(movieEntity.id, movieEntity.title, movieEntity.director)
        } else {
            null
        }
    }

    override suspend fun addMovie(movie: MovieEntity):Long {
       return movieDao.insert(MovieEntity(movie.id, movie.title, movie.director))
    }

    override suspend fun updateMovie(movie: MovieEntity) {
        movieDao.update(MovieEntity(movie.id, movie.title, movie.director))
    }

    override suspend fun deleteMovie(id: Int) {
        movieDao.delete(id)
    }

}
