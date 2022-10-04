package com.franciscojavier.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.franciscojavier.myapplication.databinding.ViewMovieBinding

class MoviesAdapter(val list:List<Movie>, val listener: (Movie) -> Unit): RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ViewMovieBinding.bind(view)
        fun bind(movie: Movie){
            binding.etTitle.text = movie.title
            Glide.with(binding.imagen)
                .load(movie.urlImagen)
                .into(binding.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener{
            listener(list[position])
        }
    }

    override fun getItemCount(): Int = list.size
}