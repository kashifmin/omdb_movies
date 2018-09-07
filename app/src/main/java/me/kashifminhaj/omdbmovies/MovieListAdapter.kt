package me.kashifminhaj.omdbmovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*
import me.kashifminhaj.omdbmovies.models.Movie

class MovieListAdapter(var movies: List<Movie>?) :
        RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_movie, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies!![position])
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) {
            with(movie) {
                itemView.titleView.text = title
                itemView.yearView.text = year
                Picasso.get().load(postUrl).into(itemView.posterView)
            }
        }
    }

}