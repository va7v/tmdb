package com.example.tmdbapp.ui.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbapp.remoteSource.Movie
import com.example.tmdbapp.repositories.TMDBApiImpl
import kotlinx.coroutines.launch

class RandomMovieModel : ViewModel() {
    private val _items = MutableLiveData<List<Movie>>()
    val items: LiveData<List<Movie>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = TMDBApiImpl.loadSomeMovies() //
        }
    }

}
