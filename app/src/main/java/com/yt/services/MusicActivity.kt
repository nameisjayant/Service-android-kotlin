package com.yt.services

import androidx.compose.runtime.Composable
import com.yt.BaseActivity
import com.yt.mynavigation.*

class MusicActivity : BaseActivity() {

    @Composable
    override fun Content() {

        PickImageFromCamera()

//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 20.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//
//        ) {
//
//            Button(onClick = {
//                Intent(this@MusicActivity, MusicService::class.java).also {
//                    startService(it)
//                }
//            }) {
//                Text(text = "START")
//            }
//
//            Button(onClick = {
//                Intent(this@MusicActivity, MusicService::class.java).also {
//                    stopService(it)
//                }
//            }, modifier = Modifier.padding(horizontal = 20.dp)) {
//                Text(text = "STOP")
//            }
//        }
    }
}

