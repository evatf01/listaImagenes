package com.example.listaimagenes


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph(navController: NavHostController){

    NavHost(navController = navController,
        startDestination = Screen.Home.route){
        composable(Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(
            Screen.Second.route,
            arguments = listOf(navArgument("id"){
                type=NavType.IntType
            },
                navArgument("titulo"){
                    type= NavType.StringType
                }, navArgument("url"){
                    type  = NavType.StringType
                },
                navArgument("temporadas"){
                    type = NavType.IntType
                })
        ) { navBackStackEntry ->
            SecondScreen(
                navBackStackEntry.arguments?.getInt("id")!!,
                navBackStackEntry.arguments?.getString("titulo")!!,
                navBackStackEntry.arguments?.getString("url")!!,
                navBackStackEntry.arguments?.getString("desc")!!,
                navBackStackEntry.arguments?.getInt("temporadas")!!
            )
        }
    }

}
