package com.example.composesleepapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composesleepapp.ui.theme.ComposeSleepAppTheme
import com.example.composesleepapp.ui.theme.SleepDarkGrey
import com.example.composesleepapp.ui.theme.SleepLightBlack
import com.example.composesleepapp.ui.theme.SleepLightGrey
import com.example.composesleepapp.views.FavScreen
import com.example.composesleepapp.views.MainScreen

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeSleepAppTheme {

                val navController = rememberNavController()

                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Scaffold(

                        containerColor = SleepLightBlack.copy(alpha = 0.5f),

                        bottomBar = {

                            NavigationBar(
                                containerColor = SleepDarkGrey
                            ) {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index

                                            // not all buttons in use
                                            // navController.navigate(item.screen_route)
                                            if (selectedItemIndex == 0) {
                                                navController.navigate(item.screen_route)
                                            } else if (selectedItemIndex == 1) {
                                                navController.navigate(item.screen_route)
                                            }

                                        },
                                        label = {
                                            Text(text = item.title, color = SleepLightGrey)
                                        },
                                        alwaysShowLabel = true,
                                        icon = {
                                            Icon(
                                                imageVector = if (index == selectedItemIndex) {
                                                    item.selectedIcon
                                                } else item.unselectedIcon,
                                                contentDescription = item.title,
                                                tint = SleepLightGrey
                                            )
                                        }
                                    )
                                }
                            }
                        },

                        ) {padding ->
                        NavHost(
                            navController = navController,
                            startDestination = BottomNavItem.Home.screen_route
                        ) {
                            composable(BottomNavItem.Home.screen_route) {
                                MainScreen(padding)
                            }
                            composable(BottomNavItem.Clock.screen_route) {
                                FavScreen(padding)
                            }
                        }
                    }
                }
            }
        }


    }
}

