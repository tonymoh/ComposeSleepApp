package com.example.composesleepapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val items = listOf(
    BottomNavItem.Home,
    BottomNavItem.Clock,
    BottomNavItem.History,
    BottomNavItem.DayEdit,
    BottomNavItem.Settings
)

sealed class BottomNavItem(var title:String, var selectedIcon:ImageVector, var unselectedIcon:ImageVector, var screen_route:String){
    object Home : BottomNavItem("Main", Icons.Filled.Home,unselectedIcon = Icons.Outlined.Home,"main")
    object Clock: BottomNavItem("Clock",Icons.Filled.Info,Icons.Outlined.Info,"favs")
    object History: BottomNavItem("History",Icons.Filled.List,unselectedIcon = Icons.Outlined.List,"history")
    object DayEdit: BottomNavItem("Day/Edit",Icons.Filled.DateRange,unselectedIcon = Icons.Outlined.DateRange,"dayedit")
    object Settings: BottomNavItem("Settings",Icons.Filled.Settings,unselectedIcon = Icons.Outlined.Settings,"settings")
}

