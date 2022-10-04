package com.franciscojavier.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.franciscojavier.myapplication.databinding.ActivityDetailBinding
import com.franciscojavier.myapplication.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_PELICULA = "movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_PELICULA)

        if (movie != null){
            binding.tvTitle.text = movie.title;
            Glide.with(binding.imagen)
                .load(movie.urlImagen)
                .into(binding.imagen)
        }
        binding.boton.setOnClickListener{
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "text")
                type = "text/plain"
            }
        // Verify that the intent will resolve to an activity
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(sendIntent)
            }
        }

    }
}