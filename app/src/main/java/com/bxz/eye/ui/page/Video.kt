package com.bxz.eye.ui.page

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bxz.eye.navi.Route

@Composable
fun Video(navController: NavController) {
    Text(text = "Video", Modifier.clickable(onClick = { navController.navigate(Route.HOME) }))
}