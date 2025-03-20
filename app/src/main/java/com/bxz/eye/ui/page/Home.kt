package com.bxz.eye.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bxz.eye.navi.Route


@Composable
fun Home(navController: NavController, modifier: Modifier) {

    Column {
        Button(onClick = {
            navController.navigate(Route.VIDEO)
        }) {
            Text(text = "视频")
        }
    }

}