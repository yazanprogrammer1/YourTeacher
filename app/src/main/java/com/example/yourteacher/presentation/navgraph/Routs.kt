package com.example.yourteacher.presentation.navgraph

sealed class Routs(val rout: String) {
    data object OnBoardingScreen : Routs("onBoardingScreen")
    data object HomeScreen : Routs("homeScreen")
    data object SearchScreen : Routs("searchScreen")
    data object FavoritesScreen : Routs("favoritesScreen")
    data object DetailsScreen : Routs("detailsScreen")
    data object AppStartNavigation : Routs("appStartNavigation")
    data object TeacherNavigation : Routs("newsNavigation")
    data object TeacherNavigatorScreen : Routs("newsNavigatorScreen")
}