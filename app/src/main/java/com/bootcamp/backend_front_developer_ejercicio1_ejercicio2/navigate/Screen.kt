package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.navigate

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object ProfileScreen : Screen("profile_screen")
}
