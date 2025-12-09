package com.example.proyecto.ui.navigation

sealed class NavRoutes(val route: String) {
    object Landing : NavRoutes("landing")
    object Login : NavRoutes("login")
    object Register : NavRoutes("register")
    object Dashboard : NavRoutes("dashboard")
    object UserProfile : NavRoutes("userProfile")
    object Requests : NavRoutes("requests")
    object Opportunities : NavRoutes("opportunities")
    object Applications : NavRoutes("applications")
    object Notifications : NavRoutes("notifications")
    object Reports : NavRoutes("reports")
}
