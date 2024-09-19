package org.example.project.ui.main.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
//    val pagerState = rememberPagerState { TODO() }
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Домашний экран")
    }
}