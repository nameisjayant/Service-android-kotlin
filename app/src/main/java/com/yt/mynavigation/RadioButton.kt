package com.yt.mynavigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow
import com.yt.mynavigation.ui.theme.Teal200

@Composable
fun RadioButtonUi() {

    val genderList by remember { mutableStateOf(listOf("Male", "Female", "Others")) }
    var genderState by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically
    ) {
        genderList.forEach {
            Row {
                Text(text = it, modifier = Modifier.align(CenterVertically))
                RadioButton(
                    selected = genderState == it, onClick = {
                        genderState = it
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Teal200
                    ),
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }
    }
}

@Composable
fun CheckBoxUi() {

    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically
    ) {
        Checkbox(
            checked = isChecked, onCheckedChange = {
                isChecked = it
            },
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Yellow,
                checkmarkColor = Color.Black,
            )
        )
    }

}

@Composable
fun CustomCheckBox() {

    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically
    ) {

        Card(
            elevation = 0.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        if (isChecked) Color.Black else Color.White
                    )
                    .size(30.dp)
                    .clickable {
                        isChecked = !isChecked
                    },
                contentAlignment = Center
            ) {
                if (isChecked)
                    Icon(
                        Icons.Default.Check, contentDescription = "check",
                        tint = Color.White
                    )
            }
        }
        Text(
            text = "I agree all the terms & conditions",
            modifier = Modifier
                .padding(start = 5.dp)
                .align(CenterVertically)
        )
    }
}

@Composable
fun AlertDialogUi() {

    var isDialog by remember { mutableStateOf(false)}

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            isDialog = true
        }) {
            Text(text = "open dialog box")
        }

        if(isDialog){
            AlertDialog(onDismissRequest = {
                isDialog = false
            },
                buttons = {
                          Button(onClick = {
                              isDialog = false
                          }, modifier = Modifier.align(CenterHorizontally)) {
                              Text(text = "Close")
                          }
                },
                title = {
                    Text(text = "Title")
                },
                text = {
                    Text(text = "Dialog box contents")
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
fun FlowColumnLayout() {
    FlowColumn {
        SampleComposeContent()
    }
}

@Composable
fun FlowRowLayout() {
    FlowRow() {
        SampleComposeContent()
    }
}

@Composable
fun SampleComposeContent() {

    repeat(30){
        Text(text = "Hello $it")
    }

}

@Composable
fun DialogBoxUi() {

    var isDialog by remember{ mutableStateOf(false)}

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            isDialog = true
        }) {
            Text(text = "Open Dialog Box")
        }
    }

   if(isDialog){
       Dialog(onDismissRequest = {
           isDialog = false
       }) {
           CircularProgressIndicator()
       }
   }
}

