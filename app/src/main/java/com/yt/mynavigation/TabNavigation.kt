package com.yt.mynavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabNavigation(

) {

    val pagerState = rememberPagerState()
    val currentIndex = pagerState.currentPage
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(selectedTabIndex = currentIndex,
            backgroundColor = Color.Yellow,
            divider = {
                TabRowDefaults.Divider(
                    thickness = 2.dp,
                    color = Color.Red
                )
            },
        ) {
            tabList.forEachIndexed { index, pair ->
                Tab(selected = currentIndex == index, onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, modifier = Modifier.padding(20.dp)) {
                    Text(text = tabList[index].tabName)
                }
            }
        }

        HorizontalPager(state = pagerState, count = tabList.size) { index ->
            Text(text = tabList[index].des)
        }
    }


}

data class Tab1(
    val tabName: String,
    val des: String
)

val tabList = listOf(
    Tab1(
        "Home",
        "This is Home page"
    ),
    Tab1(
        "Image",
        "This is image page"
    ),
    Tab1(
        "Videos",
        "This is Video page"
    )
)
