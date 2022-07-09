package com.yt.services

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yt.BaseActivity

class MusicActivity : BaseActivity() {

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Button(onClick = {
                Intent(this@MusicActivity, MusicService::class.java).also {
                    startService(it)
                }
            }) {
                Text(text = "START")
            }

            Button(onClick = {
                Intent(this@MusicActivity, MusicService::class.java).also {
                    stopService(it)
                }
            }, modifier = Modifier.padding(horizontal = 20.dp)) {
                Text(text = "STOP")
            }
        }
    }
}