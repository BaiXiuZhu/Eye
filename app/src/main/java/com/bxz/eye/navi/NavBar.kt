package com.bxz.eye.navi

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavBar(
    navController: NavController,
    items: List<NavBarItem>,
    onItemSelected: (NavBarItem) -> Unit
) {

    NavigationBar {
        items.forEach { item ->
            val currentDestination = navController.currentBackStackEntryAsState().value?.destination
            val isSelected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            val icon = if (isSelected) item.icon else item.image
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    onItemSelected(item)
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = item.label
                    )
               },
                label = {
                    Text(item.label)
                },
                alwaysShowLabel = true
            )
        }
    }
}

data class NavBarItem(
    val route: String,
    val icon: ImageVector,
    val label: String,
    val image: ImageVector
)