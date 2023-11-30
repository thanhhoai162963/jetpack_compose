package com.example.composetutorial.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composetutorial.ui.AccountScreen
import com.example.composetutorial.ui.AccountScreen2
import com.example.composetutorial.ui.AccountScreen3
import com.example.composetutorial.ui.HomeScreen

@Composable
fun NavigationExample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onClick = {
                navController.navigate("AccountScreen")
            })
        }
        composable("AccountScreen") {
            AccountScreen(data = null) {
                navController.navigate("AccountScreen2/$it/$it")
            }
        }
        composable(
            "AccountScreen2/{demo}/{demo1}", listOf(
                navArgument("demo") {

                },
                navArgument("demo1") {

                }
            )
        ) {
            val data = it.arguments?.getInt("demo")
            AccountScreen2(navigationOnClick = {
                navController.navigate("AccountScreen3?userId=$it")
            }, number = data)
        }
        composable(
            "AccountScreen3?userId={userId}", listOf(
                navArgument("userId") {

                },
            )
        ) {
            val userId = it.arguments?.getInt("userId")
            AccountScreen3(userId = userId) {
                navController.popBackStack(
                    route = "AccountScreen2/${1}/${1}",
                    inclusive = false,
                    saveState = false
                )
            }
        }
    }
}