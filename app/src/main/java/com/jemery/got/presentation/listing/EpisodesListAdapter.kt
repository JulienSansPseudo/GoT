package com.jemery.got.presentation.listing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jemery.got.R
import com.jemery.got.domain.model.Episode

class EpisodesListAdapter(
    private val onSelect: (Episode) -> Unit
): ListAdapter<Episode, EpisodeViewHolder>(EpisodesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {

        val view = when (viewType) {
            0 -> LayoutInflater.from(parent.context)
                .inflate(R.layout.episode_item_large, parent, false)
            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.episode_item, parent, false)
        }

        return EpisodeViewHolder(view, onSelect)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = getItem(position)
        holder.bind(episode)
    }

    override fun getItemViewType(position: Int): Int {
        return position % 5
    }

}