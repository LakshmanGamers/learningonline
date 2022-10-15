package com.jbc7ag.navigation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jbc7ag.navigation.screens.course.CourseScreen
import com.jbc7ag.navigation.screens.detail.DetailScreen
import com.jbc7ag.navigation.screens.home.HomeScreen
import com.jbc7ag.navigation.screens.login.LoginScreen

@ExperimentalPagerApi
@ExperimentalFoundationApi
@OptIn(ExperimentalUnitApi::class)
@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route)
    {
        composable(route = Screens.Login.route){
            LoginScreen(navController)
        }
        composable(route = Screens.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screens.Detail.route){
            DetailScreen(navController)
        }
        composable(route = Screens.Course.route){
            CourseScreen(navController)
        }
    }
}