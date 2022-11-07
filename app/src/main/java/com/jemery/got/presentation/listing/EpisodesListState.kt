package com.jemery.got.presentation.listing

import com.jemery.got.domain.model.Episode

data class EpisodesListState(
    val episodes: List<Episode> = emptyList(),
)
