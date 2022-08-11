package com.yt.mynavigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CreateText() {

   Row(
       modifier = Modifier.fillMaxWidth()
   ) {
       Text(
           text = "Testing with textdefdsfsdasdadsddsdssddddsdsddewdsddddsdsssssssdwwsssd",
           textAlign = TextAlign.Center,
           fontSize = 14.sp,
           fontWeight = FontWeight.W700,
           fontFamily = FontFamily.SansSerif,
//        letterSpacing = 10.sp,
//           lineHeight = 5.sp,
           textDecoration = TextDecoration.Underline,
           softWrap = true
       )
   }

}