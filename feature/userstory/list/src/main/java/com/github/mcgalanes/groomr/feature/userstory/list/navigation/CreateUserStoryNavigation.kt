package com.github.mcgalanes.groomr.feature.userstory.list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.github.mcgalanes.groomr.feature.userstory.list.ui.UserStoryListScreen

const val userStoryListRoute = "userstory_list_route"

fun NavController.navigateToUserStoryList(navOptions: NavOptions? = null) =
    navigate(userStoryListRoute, navOptions)

fun NavGraphBuilder.userStoryListScreen() {
    composable(route = userStoryListRoute) {
        UserStoryListScreen()
    }
}
