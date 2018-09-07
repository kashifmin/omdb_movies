package me.kashifminhaj.omdbmovies

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.kashifminhaj.omdbmovies.models.Movie


class MainViewModel : ViewModel() {
    private val restService = createRestService()
    val movieList = MutableLiveData<List<Movie>>()

    fun fetchMovies(queryText: String) {
        restService.getMovies(queryText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                {res -> movieList.value = res.search ; Log.d("k", "Network req done")},
                {error -> Log.d("MainViewModel", error.message)}
        )
    }
}