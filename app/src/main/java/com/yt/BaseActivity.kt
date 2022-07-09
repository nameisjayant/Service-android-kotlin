package com.yt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.yt.mynavigation.ui.theme.MyNavigationTheme

abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavigationTheme() {
                androidx.compose.material.Surface {
                    Content()
                }
            }
        }
    }

    @Composable
    abstract fun Content()
}