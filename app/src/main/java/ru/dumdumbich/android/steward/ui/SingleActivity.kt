package ru.dumdumbich.android.steward.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ru.dumdumbich.android.steward.ui.extention.TabNavigationBarItem
import ru.dumdumbich.android.steward.ui.tab.home.HomeTab
import ru.dumdumbich.android.steward.ui.tab.setting.SettingTab
import ru.dumdumbich.android.steward.ui.tab.tools.ToolsTab

class SingleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Content()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content() {
        TabNavigator(
            HomeTab,
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = listOf(HomeTab, SettingTab, ToolsTab)
                )
            }
        ) { tabNavigator ->
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = tabNavigator.current.options.title
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TopAppBarColors(
                            containerColor = Color.DarkGray,
                            scrolledContainerColor = Color.DarkGray,
                            navigationIconContentColor = Color.White,
                            titleContentColor = Color.White,
                            actionIconContentColor = Color.White,
                        )
                    )
                },
                content = { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Gray)
                            .padding(innerPadding)
                    ) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    NavigationBar(
                        //contentColor = Color.DarkGray,
                        containerColor = Color.Black,

                        ) {
                        TabNavigationBarItem(HomeTab)
                        TabNavigationBarItem(SettingTab)
                        TabNavigationBarItem(ToolsTab)
                    }
                }
            )
        }
    }
}
