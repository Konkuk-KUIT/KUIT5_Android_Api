package com.example.kuitandroidapiexample.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.kuitandroidapiexample.detail.screen.DetailScreen
import com.example.kuitandroidapiexample.home.screen.HomeScreen
import com.example.kuitandroidapiexample.register.screen.RegisterScreen

@Composable
fun MainNavHost(
    padding: PaddingValues
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreen(
                padding = padding,
                navigateToRegister = { navController.navigate(Route.Register) },
                navigateToDetail = { index ->
                    navController.navigate(Route.Detail(index = index))
                }
            )
        }
        composable<Route.Register> {
            RegisterScreen(padding = padding)
        }
        composable<Route.Detail> { navBackStackEntry ->
            val index: Int = navBackStackEntry.toRoute()

            DetailScreen(
                padding = padding,
                index = index
            )
        }
    }

}