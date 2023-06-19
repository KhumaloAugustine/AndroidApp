package com.example.stylesphere.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen()
        }
        composable("login") {
            LoginActivity()
        }
        composable("register") {
            RegisterActivity()
        }
        // Add more destinations for other screens
    }
}

