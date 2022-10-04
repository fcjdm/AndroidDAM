package com.franciscojavier.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.franciscojavier.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recycler.adapter = MoviesAdapter(movies) {
                    movie->
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_PELICULA, movie)
                startActivity(intent)
            }
        }
        //OTRA FORMA DE HACERLO (QUITAR EL .apply)
       /* with(binding){
            setContentView(root)
            recycler.adapter = MoviesAdapter(movies) {
                    movie->
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_PELICULA, movie)
                startActivity(intent)
            }
        }*/
    }

    private val movies = (1..100).map{
        Movie("Título $it",
            "https://loremflickr.com/g/240/320/paris,girl/lock=$it")
    }


}