package com.example.proyecto.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proyecto.ui.screens.landing.LandingScreen
import com.example.proyecto.ui.screens.auth.LoginScreen
import com.example.proyecto.ui.screens.auth.RegisterScreen
import com.example.proyecto.ui.screens.dashboard.DashboardScreen
import com.example.proyecto.ui.screens.profile.UserProfileScreen
import com.example.proyecto.ui.screens.requests.RequestsScreen
import com.example.proyecto.ui.screens.opportunities.OpportunitiesScreen
import com.example.proyecto.ui.screens.opportunities.ApplicationsScreen
import com.example.proyecto.ui.screens.notifications.NotificationsScreen
import com.example.proyecto.ui.screens.dashboard.ReportsScreen // Assuming Reports is in dashboard or separate

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavRoutes.Landing.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavRoutes.Landing.route) {
            LandingScreen(
                onLoginClick = { navController.navigate(NavRoutes.Login.route) },
                onRegisterClick = { navController.navigate(NavRoutes.Register.route) }
            )
        }
        composable(NavRoutes.Login.route) {
            LoginScreen(
                onLoginSuccess = { 
                    navController.navigate(NavRoutes.Dashboard.route) {
                        popUpTo(NavRoutes.Landing.route) { inclusive = true }
                    }
                },
                onRegisterClick = { navController.navigate(NavRoutes.Register.route) }
            )
        }
        composable(NavRoutes.Register.route) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(NavRoutes.UserProfile.route) {
                         popUpTo(NavRoutes.Landing.route) { inclusive = true }
                    }
                },
                onLoginClick = { navController.navigate(NavRoutes.Login.route) }
            )
        }
        composable(NavRoutes.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(NavRoutes.UserProfile.route) {
            UserProfileScreen(navController = navController)
        }
        composable(NavRoutes.Requests.route) {
            RequestsScreen(navController = navController)
        }
        composable(NavRoutes.Opportunities.route) {
            OpportunitiesScreen(navController = navController)
        }
        composable(NavRoutes.Applications.route) {
            ApplicationsScreen(navController = navController)
        }
        composable(NavRoutes.Notifications.route) {
            NotificationsScreen(navController = navController)
        }
        composable(NavRoutes.Reports.route) {
            ReportsScreen(navController = navController)
        }
    }
}
