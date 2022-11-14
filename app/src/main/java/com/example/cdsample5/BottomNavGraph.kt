package com.example.cdsample5

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cdsample5.screens.ProfileScreen
import com.example.cdsample5.screens.Reserving
import com.example.cdsample5.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
    navController = navController,
    startDestination = BottomBarScreen.Reserving.route
    ) {
        composable(route = BottomBarScreen.Reserving.route) {
            Reserving()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }


}