package com.yt.mynavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.*
import com.yt.mynavigation.ui.theme.MyNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TabNavigator(tab = HomeScreen) {
                        Scaffold(
                            bottomBar = {
                                BottomNavigation {
                                    TabNavigationItems(tab = HomeScreen)
                                    TabNavigationItems(tab = Profile)
                                }
                            }
                        ) {
                            CurrentTab()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItems(tab: Tab) {
    val navigator = LocalTabNavigator.current
    BottomNavigationItem(selected = navigator.current == tab,
        onClick = { navigator.current = tab },
        icon = { Icon(tab.options.icon!!, contentDescription = tab.options.title)})
}

object HomeScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    0u,
                    title,
                    icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "Home Screen")
    }
}

object Profile : Tab {

    override val options: TabOptions
        @Composable
        get() {

            val title = "Profile"
            val icon = rememberVectorPainter(Icons.Default.Person)
            return remember {
                TabOptions(
                    1u,
                    title, icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "Profile")
    }


}

