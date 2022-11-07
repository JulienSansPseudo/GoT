package com.jemery.got.presentation.listing

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jemery.got.R
import com.jemery.got.domain.model.Episode

class EpisodeViewHolder(
    itemView: View,
    val onSelect: (Episode) -> Unit
): RecyclerView.ViewHolder(itemView) {

    private val numbersView: TextView = itemView.findViewById(R.id.episode_number)
    private val nameView: TextView = itemView.findViewById(R.id.episode_name)
    private val imageView: ImageView = itemView.findViewById(R.id.episode_image)
    private val summaryView: TextView? = itemView.findViewById(R.id.episode_summary)

    private var currentEpisode: Episode? = null

    init {
        itemView.setOnClickListener {
            currentEpisode?.let {
                onSelect(it)
            }
        }
    }

    fun bind(episode: Episode) {
        currentEpisode = episode

        val numbers = "Season ${episode.season} / Episode ${episode.number}"
        numbersView.text = numbers
        nameView.text = episode.name
        imageView.load(episode.image)

        summaryView?.let {
            it.text = Html.fromHtml(episode.summary)
        }
    }
}