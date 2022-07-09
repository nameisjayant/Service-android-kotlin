package com.yt.intentService

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yt.BaseActivity

class MyIntentServiceActivity : BaseActivity() {

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
                Intent(this@MyIntentServiceActivity, MyIntentService::class.java).also {
                    startService(it)
                }
            }) {
                Text(text = "START")
            }

            Button(onClick = {
                MyIntentService.stopService()
            }, modifier = Modifier.padding(horizontal = 20.dp)) {
                Text(text = "STOP")
            }

        }
    }
}