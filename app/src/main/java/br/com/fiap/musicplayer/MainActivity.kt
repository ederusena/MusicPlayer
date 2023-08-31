package br.com.fiap.musicplayer

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.musicplayer.ui.theme.MusicPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AudioPlayer(this)
                }
            }
        }
    }
}

@Composable
fun AudioPlayer(context: Context) {

    var player by remember {
        mutableStateOf(MediaPlayer.create(context, R.raw.dimmu))
    }

    Box(contentAlignment = Alignment.Center) {
        Row() {

            IconButton(onClick = {
                if(player == null) {
                    player = MediaPlayer.create(context, R.raw.dimmu)
                }
                player.start()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            }

            IconButton(onClick = {
                player.pause()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.pause),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            }

            IconButton(onClick = {
                player.reset()
                player.release()
                player.stop()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.stop),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            }

        }
    }
}