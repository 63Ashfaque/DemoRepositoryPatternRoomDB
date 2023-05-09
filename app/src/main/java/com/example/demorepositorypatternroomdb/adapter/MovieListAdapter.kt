package com.example.demorepositorypatternroomdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demorepositorypatternroomdb.R
import com.example.demorepositorypatternroomdb.roomdb.MovieEntity

class MovieListAdapter(private val movies: List<MovieEntity>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleTextView.text = movie.title
        holder.directorTextView.text = movie.director
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView = itemView.findViewById(R.id.tvTitle)
    val directorTextView: TextView = itemView.findViewById(R.id.tvDesc)
}