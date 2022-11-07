package com.jemery.got.presentation.listing

import androidx.recyclerview.widget.DiffUtil
import com.jemery.got.domain.model.Episode

class EpisodesDiffCallback: DiffUtil.ItemCallback<Episode>() {

    override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem.id == newItem.id
    }
}