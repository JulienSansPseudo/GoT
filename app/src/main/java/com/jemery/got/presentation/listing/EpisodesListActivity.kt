package com.jemery.got.presentation.listing

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jemery.got.R
import com.jemery.got.domain.model.Episode
import com.jemery.got.presentation.detail.EpisodeDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesListActivity(): AppCompatActivity() {

    private val viewModel: EpisodesListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.episodes_list)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = EpisodesListAdapter {
                episode -> adapterOnSelect(episode)
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                layoutManager.orientation
            )
        )
        viewModel.episodesLiveData.observe(this) {
            it?.let {
                adapter.submitList(it as MutableList<Episode>)
            }
        }

    }

    private fun adapterOnSelect(episode: Episode) {
        val intent = Intent(this, EpisodeDetailsActivity()::class.java)
        intent.putExtra("name", episode.name)
        intent.putExtra("episode", episode)
        startActivity(intent)
    }
}