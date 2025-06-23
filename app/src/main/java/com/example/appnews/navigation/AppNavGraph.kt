package com.example.appnews.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appnews.ui.screens.detailsscreen.DetailsViewModel
import com.example.appnews.ui.screens.homescreen.PostViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            val viewModel: PostViewModel = hiltViewModel()
            //HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable("details/{postTitle}/{imageUrl}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("postTitle") ?: ""
            val imageUrl = backStackEntry.arguments?.getString("imageUrl") ?: ""
            val viewModel: DetailsViewModel = hiltViewModel()
           // DetailsScreen(title = title, imageUrl = imageUrl, viewModel = viewModel)
        }
    }
}