package com.jemery.got.domain.model

data class Episode(
    val id: Long,
    val url: String,
    val name: String,
    val season: Int,
    val number: Int,
    val runtime: Long,
    val summary: String,
    val image: String
): java.io.Serializable
