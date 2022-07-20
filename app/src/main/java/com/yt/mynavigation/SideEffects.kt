package com.yt.mynavigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@Composable
fun SnackBar(scaffoldState: ScaffoldState) {

    val scope = rememberCoroutineScope()

    Button(onClick = {
       scope.launch {
           scaffoldState.snackbarHostState.showSnackbar("Hello , how are you?")
       }

    }) {
       Text(text = "Show SnackBar")
    }

}

@Composable
fun ShowDrawer(scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    IconButton(onClick = {
       scope.launch {
           scaffoldState.drawerState.open()
       }
    }) {
        Icon(Icons.Default.List, contentDescription = "" , tint = Color.Blue)
    }

}