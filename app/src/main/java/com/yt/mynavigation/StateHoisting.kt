package com.yt.mynavigation

import androidx.compose.material.Text
import androidx.compose.runtime.*


@Composable
fun StateHoisting() {


}

@Composable
fun StateFul() {
    var name by remember { mutableStateOf("")}
}

@Composable
fun Stateless() {
    Text(text = "hello world")
}