package com.example.yourteacher.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.yourteacher.presentation.onboarding.OnBoardingScreen
import com.example.yourteacher.presentation.onboarding.OnBoardingViewModel
import com.example.yourteacher.presentation.teacher_navigator.TeacherNavigator

@Composable
fun NavGraph(
    startDestination: String,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Routs.AppStartNavigation.rout,
            startDestination = Routs.OnBoardingScreen.rout
        ) {
            composable(
                route = Routs.OnBoardingScreen.rout
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
//                        event = viewModel::onEvent
                    event = {
                        viewModel.onEvent(it)
                    }
                )
            }
        }
        navigation(
            route = Routs.TeacherNavigation.rout,
            startDestination = Routs.TeacherNavigatorScreen.rout
        ) {
            composable(
                route = Routs.TeacherNavigatorScreen.rout
            ) {
                TeacherNavigator()
            }
        }
    }
}