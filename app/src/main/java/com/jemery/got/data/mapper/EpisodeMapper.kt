package com.jemery.got.data.mapper

import com.jemery.got.data.remote.dto.EpisodeDto
import com.jemery.got.domain.model.Episode

fun EpisodeDto.toEpisode(): Episode {
    return Episode(
        id = id ?: 0,
        url = url ?: "",
        name = name ?: "",
        season = season ?: 0,
        number = number ?: 0,
        runtime = runtime ?: 0,
        summary = summary ?: "",
        image = image?.original ?: ""
    )
}