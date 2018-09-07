package me.kashifminhaj.omdbmovies

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel!!.fetchMovies("Lord")


        val adapter = MovieListAdapter(null)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        viewModel?.movieList?.observe(this, Observer {
            Log.d("MainActivity", "Got new movies")
            adapter.movies = it
            adapter.notifyDataSetChanged()
        })
    }
}
