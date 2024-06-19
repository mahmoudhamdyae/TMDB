package com.mahmoudhamdyae.tmdb

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.window.core.layout.WindowWidthSizeClass
import com.mahmoudhamdyae.tmdb.movies.representations.MoviesScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    val adaptiveInfo = currentWindowAdaptiveInfo()
    val customNavSuiteType = with(adaptiveInfo) {
        if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED) {
            NavigationSuiteType.NavigationDrawer
        } else {
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        }
    }
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                AppDestinations.entries.forEach {
                    item(
                        selected = it == currentDestination,
                        onClick = {
                            currentDestination = it
                        },
                        icon = {
                            Icon(
                                imageVector = it.icon,
                                contentDescription = stringResource(id = it.contentDescription)
                            )
                        },
                        label = {
                            Text(text = stringResource(id = it.title))
                        }
                    )
                }
            },
                    layoutType = customNavSuiteType,
        ) {
            when (currentDestination) {
                AppDestinations.HOME -> MoviesScreen()
                AppDestinations.SEARCH -> MoviesScreen()
                AppDestinations.SETTINGS -> MoviesScreen()
            }
        }
    }
}

enum class AppDestinations(
    @StringRes val title: Int,
    val icon: ImageVector,
    @StringRes val contentDescription: Int
) {
    HOME(R.string.navigation_movies, Icons.Default.Home, R.string.navigation_movies),
    SEARCH(R.string.navigation_tv, Icons.Default.Search, R.string.navigation_tv),
    SETTINGS(R.string.navigation_profile, Icons.Default.Settings, R.string.navigation_profile),
}