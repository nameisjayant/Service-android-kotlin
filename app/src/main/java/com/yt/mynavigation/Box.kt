package com.yt.mynavigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@Composable
fun BoxLayout() {

    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello 1")
        Text(text = "hello 2", modifier = Modifier.align(Alignment.BottomCenter))
        Text(text = "hello 3", modifier = Modifier.align(Alignment.TopCenter))
        Button(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterEnd)) {
            Text(text = "Hey")
        }
    }

}

@Composable
fun TextLayout() {

    Text(text = "Hey,nnsdmdmmccmm,dmdmdmdmdmdsmsdmdmdmsddsdmdms,d,ś,dm,smdsdsm,sdm.dsbdmnmsdnm,dsn,sdmddsmdmdmsm",
      //  maxLines = 1,
        overflow = TextOverflow.Visible,
        textAlign = TextAlign.Center,
    )

}

@Composable
fun ButtonLayout() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { /*TODO*/ },
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(text = "Normal Button")
        }

        TextButton(onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(

            )
        ) {
           Text(text = "Text Button")
        }

        OutlinedButton(onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(
            ),
            elevation = ButtonDefaults.elevation(

            )
        ) {
            Text(text = "Outlined Button")
        }
    }

}
