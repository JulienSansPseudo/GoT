package com.jemery.got.presentation.detail

import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.jemery.got.R
import com.jemery.got.domain.model.Episode

class EpisodeDetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.episode_details)

        var episodeName: String? = null
        var episode: Episode? = null

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            episodeName = bundle.getString("name")
            episode = bundle.getSerializable("episode") as Episode
        }

        val nameView: TextView = findViewById(R.id.episode_name)
        nameView.text = episodeName

        val imageView: ImageView = findViewById(R.id.episode_image)
        imageView.load(episode?.image)

        val summaryView: TextView = findViewById(R.id.episode_summary)
        summaryView.text = Html.fromHtml(episode?.summary)

        val runtimeView: TextView = findViewById(R.id.episode_duration)
        runtimeView.text = episode?.runtime.toString()


    }

}