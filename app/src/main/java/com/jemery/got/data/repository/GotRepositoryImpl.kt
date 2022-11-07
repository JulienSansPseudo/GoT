package com.jemery.got.data.repository

import com.jemery.got.data.mapper.toEpisode
import com.jemery.got.data.remote.GotApi
import com.jemery.got.domain.model.Episode
import com.jemery.got.domain.repository.GotRepository
import javax.inject.Inject

class GotRepositoryImpl @Inject constructor(
    private val api: GotApi
) : GotRepository {

    override suspend fun getEpisodesList(): Result<List<Episode>> {

        val remoteEpisodes = try {
            api.getEpisodes()

        } catch (e: Exception) {
            e.printStackTrace()
            return Result.failure(e)
        }

        val episodes = remoteEpisodes._embedded
            .episodes.map { it.toEpisode() }

        return Result.success(episodes)
    }

}
