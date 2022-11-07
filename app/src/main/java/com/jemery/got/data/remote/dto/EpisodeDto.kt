package com.jemery.got.data.remote.dto

data class EpisodeDto(
    val id: Long?,
    val url: String?,
    val name: String?,
    val season: Int?,
    val number: Int?,
    val runtime: Long?,
    val summary: String?,
    val image: EpisodeImageDto?
)
