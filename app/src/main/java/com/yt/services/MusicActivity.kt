package com.yt.services

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.yt.BaseActivity
import com.yt.mynavigation.*
import kotlinx.coroutines.launch

class MusicActivity : BaseActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    override fun Content() {

        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                Column(
                    modifier = Modifier.fillMaxWidth(.5f)
                ) {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                    }) {
                        Icon(Icons.Default.Close, contentDescription = "", tint = Color.Blue)
                    }
                    Text(text = "Drawer content")
                }
            },
            drawerGesturesEnabled = false,
        ) {
            //   ShowDrawer(scaffoldState = scaffoldState)
            //TabNavigation()
            // ConstraintLayoutDemo()
           CustomToggleButton()
        }

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

