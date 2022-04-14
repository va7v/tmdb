package com.example.tmdbapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.buttomnavigation.R
import com.example.buttomnavigation.databinding.LayoutItemBinding
import com.example.tmdbapp.data.Movie
import com.squareup.picasso.Picasso

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private val items = mutableListOf<Movie>()

    inner class ViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(
            LayoutItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() : Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleTextView.text = items[position].title + "  (" +
                (items[position].vote_average).toString() + ")"
        holder.binding.dateTextView.text = items[position].data
        Picasso.get().load(BASE_IMAGE_URL + items[position].poster_path).into(holder.binding.imageView)

        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_navigation_random_to_navigation_details)
        )
    }

    fun addItems(newItems: List<Movie>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }




    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
    }
}