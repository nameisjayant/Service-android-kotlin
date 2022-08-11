package com.yt.mynavigation

//import androidx.compose.foundation.layout.Column
//import androidx.compose.material.Tab
//import androidx.compose.material.TabRow
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import com.google.accompanist.pager.ExperimentalPagerApi
//import com.google.accompanist.pager.HorizontalPager
//import com.google.accompanist.pager.rememberPagerState
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun TabNavigation(
//
//) {
//    val tabData = arrayListOf<Pair<String, String>>()
//    tabList.map { data ->
//        tabData.add(Pair(data.tabName, data.des))
//    }
//    val pagerState = rememberPagerState(
//        initialPage = 0
//    )
//    val currentIndex = pagerState.currentPage
//    val scope = rememberCoroutineScope()
//
//    Column {
//        TabRow(selectedTabIndex = currentIndex) {
//            tabData.forEachIndexed { index, pair ->
//                Tab(selected = currentIndex == index, onClick = {
//                    scope.launch {
//                        pagerState.scrollToPage(pagerState.currentPage+1)
//                    }
//                }) {
//                    Text(text = pair.first)
//                }
//            }
//        }
//
//        HorizontalPager(state = pagerState, count = pagerState.currentPage) { index ->
//            Text(text = tabData[index].first)
//        }
//    }
//
//
//}
//
//data class Tab1(
//    val tabName: String,
//    val des: String
//)
//
//val tabList = listOf(
//    Tab1(
//        "Home",
//        "This is Home page"
//    ),
//    Tab1(
//        "Image",
//        "This is image page"
//    ),
//    Tab1(
//        "Videos",
//        "This is Video page"
//    )
//)
