package com.jemery.got.domain.repository

import com.jemery.got.domain.model.Episode

interface GotRepository {

    suspend fun getEpisodesList(): Result<List<Episode>>

}