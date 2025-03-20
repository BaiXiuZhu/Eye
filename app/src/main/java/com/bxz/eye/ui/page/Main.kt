package com.bxz.eye.ui.page

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bxz.eye.R
import com.bxz.eye.navi.NavBar
import com.bxz.eye.navi.NavGraph
import com.bxz.eye.navi.NavBarItem
import com.bxz.eye.navi.Route

@Composable
fun Main(navHostController: NavHostController) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val items = listOf(
        NavBarItem(
            route = Route.HOME,
            icon = Icons.Outlined.Home,
            image = Icons.Filled.Home,
            label = stringResource(id = R.string.home)
        ),
        NavBarItem(
            route = Route.SEARCH,
            icon = Icons.Outlined.Search,
            image = Icons.Filled.Search,
            label = stringResource(id = R.string.search)
        ),
        NavBarItem(
            route = Route.MINE,
            icon = Icons.Outlined.AccountCircle,
            image = Icons.Filled.AccountCircle,
            label = stringResource(id = R.string.mine)
        )
    )
    Scaffold(
        bottomBar = {
            if (currentDestination ?.hierarchy?.any {
                    items.map {
                        it.route
                    }.contains(
                        it.route
                    )
                } == true) {
                NavBar(navController = navHostController, items = items) {
                    navHostController.navigate(it.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // 栈顶复用，避免重复点击同一个导航按钮，回退栈中多次创建实例
                        launchSingleTop = true
                        // 回退时恢复页面状态
                        restoreState = true
                    }
                }
            }
        }
    ) { paddings ->
        NavGraph(navHostController = navHostController, paddingValues = paddings)
    }
}