package org.christophertwo.gallery.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.christophertwo.gallery.presentation.screens.gallery.GalleryRoot
import org.christophertwo.gallery.utils.RoutesApp
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    startDestination: String = RoutesApp.Gallery.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(RoutesApp.Gallery.route) {
            GalleryRoot(
                viewModel = koinViewModel()
            )
        }
    }
}