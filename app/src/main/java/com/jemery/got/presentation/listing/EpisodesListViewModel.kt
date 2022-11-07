package com.jemery.got.presentation.listing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jemery.got.domain.model.Episode
import com.jemery.got.domain.repository.GotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesListViewModel @Inject constructor(
    private val repository: GotRepository
): ViewModel() {

    var state by mutableStateOf(EpisodesListState())
    val episodesLiveData = MutableLiveData<List<Episode>>(null)

    init {
        loadEpisodes()
    }

    private fun loadEpisodes() {
        viewModelScope.launch {

            val result = repository.getEpisodesList()

            val episodes = result.getOrElse {
                state = state.copy(
                    //error = it.localizedMessage
                )
            }

            state = state.copy(episodes = episodes as List<Episode>)

            episodesLiveData.postValue(episodes)
        }
    }

}