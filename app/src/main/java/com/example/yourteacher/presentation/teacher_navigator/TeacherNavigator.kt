package com.example.yourteacher.presentation.teacher_navigator

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yourteacher.R
import com.example.yourteacher.domain.model.TeacherUiModel
import com.example.yourteacher.presentation.navgraph.Routs
import com.example.yourteacher.presentation.teacher_navigator.components.BottomNavigationItem
import com.example.yourteacher.presentation.teacher_navigator.components.TeacherBottomNavigation

@Composable
fun TeacherNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),
        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    selectedItem = when (backStackState?.destination?.route) {
        Routs.HomeScreen.rout -> 0
        Routs.SearchScreen.rout -> 1
        Routs.FavoritesScreen.rout -> 2
        else -> 0
    }

    //Hide the bottom navigation when the user is in the details screen
    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Routs.HomeScreen.rout ||
                backStackState?.destination?.route == Routs.SearchScreen.rout ||
                backStackState?.destination?.route == Routs.FavoritesScreen.rout
    }


    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        if (isBottomBarVisible) {
            TeacherBottomNavigation(
                items = bottomNavigationItems,
                selectedItem = selectedItem,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = Routs.HomeScreen.rout
                        )

                        1 -> navigateToTab(
                            navController = navController,
                            route = Routs.SearchScreen.rout
                        )

                        2 -> navigateToTab(
                            navController = navController,
                            route = Routs.FavoritesScreen.rout
                        )
                    }
                }
            )
        }
    }) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Routs.HomeScreen.rout,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Routs.HomeScreen.rout) { backStackEntry ->
//                val viewModel: HomeViewModel = hiltViewModel()
//                //val articles = viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(
//                    articles = articles,
//                    navigateToSearch = {
//                        navigateToTab(
//                            navController = navController,
//                            route = Routs.SearchScreen.rout
//                        )
//                    },
//                    navigateToDetails = { article ->
//                        navigateToDetails(
//                            navController = navController,
//                            article = article
//                        )
//                    }
//                )
            }
            composable(route = Routs.SearchScreen.rout) {
//                val viewModel: SearchViewModel = hiltViewModel()
//                val state = viewModel.state.value
//                OnBackClickStateSaver(navController = navController)
//                SearchScreen(
//                    state = state,
//                    event = viewModel::onEvent,
//                    navigateToDetails = { article ->
//                        navigateToDetails(
//                            navController = navController,
//                            article = article
//                        )
//                    }
//                )
            }
            composable(route = Routs.DetailsScreen.rout) {
//                val viewModel: DetailsViewModel = hiltViewModel()
//                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
//                    ?.let { article ->
//                        DetailsScreen(
//                            article = article,
//                            event = viewModel::onEvent,
//                            navigateUp = { navController.navigateUp() },
//                            sideEffect = viewModel.sideEffect
//                        )
//                    }
            }
            composable(route = Routs.FavoritesScreen.rout) {
//                val viewModel: BookmarkViewModel = hiltViewModel()
//                val state = viewModel.state.value
//                OnBackClickStateSaver(navController = navController)
//                BookmarkScreen(
//                    state = state,
//                    navigateToDetails = { article ->
//                        navigateToDetails(
//                            navController = navController,
//                            article = article
//                        )
//                    }
//                )
            }
        }
    }
}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Routs.HomeScreen.rout
        )
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}

private fun navigateToDetails(navController: NavController, teacher: TeacherUiModel) {
    navController.currentBackStackEntry?.savedStateHandle?.set("teacher", teacher)
    navController.navigate(
        route = Routs.DetailsScreen.rout
    )
}