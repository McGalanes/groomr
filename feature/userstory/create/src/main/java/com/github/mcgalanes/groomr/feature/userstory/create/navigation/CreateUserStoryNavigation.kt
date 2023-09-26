package com.github.mcgalanes.groomr.feature.userstory.create.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.github.mcgalanes.groomr.feature.userstory.create.ui.CreateUserStoryScreen

const val createUserStoryRoute = "create_userstory_route"

fun NavController.navigateToCreateUserStory(navOptions: NavOptions? = null) =
    navigate(createUserStoryRoute, navOptions)

fun NavGraphBuilder.createUserStoryScreen() {
    composable(route = createUserStoryRoute) {
        CreateUserStoryScreen(
            onBackClick = {},
        )
    }
}
