package com.example.youtube20bce7164

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Color.Black)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    item {
                        Image(
                            painter =
                            painterResource(id = R.drawable.youtube),
                            contentDescription = "",
                            modifier = Modifier.size(100.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        YoutubeScreen(videoId = "4GuqB1BQVr4")

                        Spacer(modifier = Modifier.height(10.dp))
                        YoutubeScreen(videoId = "EgT_us6AsDg")

                        Spacer(modifier = Modifier.height(10.dp))
                        YoutubeScreen(videoId = "1ekZEVeXwek")

                        Spacer(modifier = Modifier.height(10.dp))
                        YoutubeScreen(videoId = "e-ORhEE9VVg")

                        Spacer(modifier = Modifier.height(10.dp))
                        YoutubeScreen(videoId = "-8VfKZCOo_I")

                        Spacer(modifier = Modifier.height(10.dp))
                        YoutubeScreen(videoId = "jzD_yyEcp0M")
                    }
                }
            }
        }
    }
}

@Composable
fun YoutubeScreen(
    videoId: String
) {
    AndroidView(factory = {
        val view = YouTubePlayerView(it)
        view.addYouTubePlayerListener(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(videoId, 0f)

                }
            }
        )
            view
    })
}