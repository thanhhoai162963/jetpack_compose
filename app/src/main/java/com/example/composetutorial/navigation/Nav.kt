package com.example.composetutorial.navigation

import androidx.compose.runtime.Composable

class Nav {
    @Composable
    fun Demo() {

        /*  val navController = rememberNavController()
          NavHost(
              navController = navController,
              startDestination = LizaiNavigation.HomeRoute.invoke()
          )
          {
              composable(LizaiNavigation.HomeRoute.invoke()) {
                  HomeScreen()
              }
          }
          NavHost(
              navController = navController,
              startDestination = Destination.HomeScreen.
          )
          {
              composable("home") {
                  HomeScreen(navigationOnClick = {
                      navController.navigate("settingAccount")
                  })
              }



              navigation(startDestination = "account", route = "settingAccount") {
                  composable("account") {
                      AccountScreen(navigationOnClick = {
                          navController.navigate("account1")
                      })
                  }
                  composable("account1") {
                      AccountScreen2(navigationOnClick = {
                          navController.navigate("account2?userId=${it}")
                      })
                  }
                  composable("account2?userId={userId}", arguments = listOf(
                      navArgument("userId") {
                          defaultValue = 0
                          type = NavType.IntType
                      }
                  )) {
                      val userId = it.arguments?.getInt("userId")
                      val userId = it.arguments?.getInt("userId")
                      requireNotNull(userId)
                      AccountScreen3(userId) {
                          navController.popBackStack()
                          navController.popBackStack(
                              "account1",
                              inclusive = false,
                              saveState = false
                          )
                      }
                  }
              }
          }*/
    }

}