package com.example.demorepositorypatternroomdb.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demorepositorypatternroomdb.R
import com.example.demorepositorypatternroomdb.adapter.MovieListAdapter
import com.example.demorepositorypatternroomdb.repository.MovieRepository
import com.example.demorepositorypatternroomdb.repository.RoomMovieRepository
import com.example.demorepositorypatternroomdb.roomdb.MovieDatabase
import com.example.demorepositorypatternroomdb.roomdb.MovieEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var movieRepository: MovieRepository
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Display the movies in a RecyclerView
        recyclerView = findViewById(R.id.recyclerView)



        // Initialize the movie repository
        movieRepository = RoomMovieRepository(MovieDatabase.getInstance(this).movieDao())
        GlobalScope.launch {
            // Get all movies from the repository
            val movies = movieRepository.getAllMovies()

            recyclerView.adapter = MovieListAdapter(movies)
        }

        //insert Dummy record
        findViewById<FloatingActionButton>(R.id.fabAdd).setOnClickListener {
            GlobalScope.launch {

                val insert = movieRepository.addMovie(
                    MovieEntity(
                        0,
                        "Title ${(0..99).random()}",
                        "Desc ${(100..999).random()}"
                    )
                )
                Log.d("Ashu", insert.toString())
                if (insert > 0) {

                    //fetch the new data
                    val movies = movieRepository.getAllMovies()

                    // Switch to the main thread to update the UI
                    withContext(Dispatchers.Main) {

                        // Update the RecyclerView adapter with the new data
                        recyclerView.adapter = MovieListAdapter(movies)
                    }
                }
            }

        }
    }

}

