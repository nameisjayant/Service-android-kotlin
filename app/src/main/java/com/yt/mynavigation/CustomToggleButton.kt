package com.yt.mynavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yt.mynavigation.ui.theme.greenColor

@Composable
fun CustomToggleButton() {

    var isToggle by remember { mutableStateOf(false)}

   Box(
       modifier = Modifier.fillMaxSize(), contentAlignment = Center
   ) {
       Card(
           shape = RoundedCornerShape(39.dp),
           elevation = 0.dp
       ) {
           Box(modifier = Modifier.background(
               if(isToggle) greenColor else Color.Black
           ).clickable{
               isToggle = !isToggle
           }, contentAlignment = Alignment.Center) {

               if(isToggle){
                   Row(
                       modifier = Modifier.padding(5.dp)
                   ) {
                       Text(text = "On", color = Color.White, style = TextStyle(
                           fontSize = 12.sp,
                           fontWeight = FontWeight.W400
                       ), modifier = Modifier.align(alignment = CenterVertically).padding(start = 5.dp))
                       Icon(painter = painterResource(id = R.drawable.on), contentDescription = "",
                           modifier = Modifier
                               .padding(start = 10.dp)
                               .size(28.dp),
                           tint = Color.Unspecified
                       )
                   }
               }
               else{
                   Row(
                       modifier = Modifier.padding(5.dp)
                   ) {
                       Icon(painter = painterResource(id = R.drawable.off), contentDescription = "",
                           modifier = Modifier.size(28.dp),
                           tint = Color.Unspecified
                       )
                       Text(text = "Off", color = Color.White, style = TextStyle(
                           fontSize = 12.sp,
                           fontWeight = FontWeight.W400
                       ),
                           modifier = Modifier.align(CenterVertically).padding(start = 10.dp, end = 5.dp)
                       )
                   }
               }

           }
       }
   }

}