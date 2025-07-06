package ru.dumdumbich.android.steward.ui.extention

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@Composable
fun RowScope.TabNavigationBarItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let { painter ->
                Icon(
                    painter = painter,
                    contentDescription = tab.options.title
                )
            }
        },
        colors = NavigationBarItemColors(
            selectedIconColor = Color.Black,
            selectedTextColor = Color.Black,
            selectedIndicatorColor = Color.Gray,
            unselectedIconColor = Color.White,
            unselectedTextColor = Color.White,
            disabledIconColor = Color.Gray,
            disabledTextColor = Color.Gray,
        )
    )
}
