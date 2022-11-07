package com.jemery.got.data.remote

import com.jemery.got.data.remote.dto.ResultDto
import retrofit2.http.GET

interface GotApi {

    @GET("got.json")
    suspend fun getEpisodes(): ResultDto

    companion object {
        const val BASE_URL = "https://beta.goandup.paris"
    }

}