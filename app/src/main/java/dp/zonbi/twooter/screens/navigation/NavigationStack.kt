package dp.zonbi.twooter.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dp.zonbi.twooter.screens.HomeScreen
import dp.zonbi.twooter.screens.SearchScreen
import dp.zonbi.twooter.screens.SettingsScreen

@Composable
fun NavigationStack(navController: NavHostController) {
    NavHost (
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) {
            HomeScreen()
        }
        composable(Screens.Search.route) {
            SearchScreen()
        }
        composable(Screens.Settings.route) {
            SettingsScreen()
        }
    }
}