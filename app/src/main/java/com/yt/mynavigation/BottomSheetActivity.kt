package com.yt.mynavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.stack.StackEvent
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.transitions.*
import com.yt.mynavigation.ui.theme.MyNavigationTheme

class BottomSheetActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavigationTheme() {
                Surface() {
//               BottomSheetNavigator(
//                   sheetShape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp),
//                   scrimColor = Color.Yellow
//               ){
//                   Navigator(screen = BottomSheetScreen)
//               }

                    Navigator(screen = FirstScreen){
                      //  SlideTransition(navigator = it)
                      //  FadeTransition(navigator = it)
                        ScaleTransition(navigator = it)
                    }

               }
            }
        }
    }
}

object BottomSheetScreen : Screen{

    @Composable
    override fun Content() {
        val navigator = LocalBottomSheetNavigator.current
        Button(onClick = {
            navigator.show(ContentScreen)
        }) {
            Text(text = "Click ")
        }
    }

}

object ContentScreen : Screen{

    @Composable
    override fun Content() {
        val navigator = LocalBottomSheetNavigator.current
        LazyColumn{
            item {
                IconButton(onClick = {
                    navigator.hide()
                }) {
                    Icon(Icons.Default.Close, contentDescription = "")
                }
            }
            items(10){data->
                Text(text = "Item $data")
            }
        }
    }

}


object FirstScreen : Screen{

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
       Button(onClick = {
           navigator push SecondScreen
       }) {
           Text(text = "First screen")
       }
    }

}

object SecondScreen : Screen{

    @Composable
    override fun Content() {
        Text(text = "Second screen")
    }

}
