package com.bxz.eye.navi

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bxz.eye.ui.page.Home
import com.bxz.eye.ui.page.Main
import com.bxz.eye.ui.page.Mine
import com.bxz.eye.ui.page.Search
import com.bxz.eye.ui.page.Video

@Composable
fun NavGraph(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navHostController, startDestination = Route.HOME, modifier = Modifier.padding(paddingValues = paddingValues)) {
        composable(Route.MAIN) {
            Main(navHostController = navHostController)
        }
        composable(Route.VIDEO) {
            Video(navController = navHostController)
        }
        composable(Route.HOME) {
            Home(navController = navHostController, modifier = Modifier.padding(paddingValues = paddingValues))
        }
        composable(Route.SEARCH) {
            Search(navController = navHostController, modifier = Modifier.padding(paddingValues = paddingValues))
        }
        composable(Route.MINE) {
            Mine(navController = navHostController, modifier = Modifier.padding(paddingValues = paddingValues))
        }
    }
}