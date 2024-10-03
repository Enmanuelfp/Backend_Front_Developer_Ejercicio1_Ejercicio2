package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.navigate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.view.HomeView
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.view.ProfileView
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.viewModel.ContactViewModel

@Composable
fun NavManager() {
    val navController = rememberNavController()
    val viewModel: ContactViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeView(navController, viewModel)
        }

        // Ruta para crear un nuevo contacto
        composable("crearperfil") {
            viewModel.setIdProfile(0L) // Establece un ID temporal para crear un nuevo contacto
            ProfileView(navController, viewModel)
        }

        // Ruta para editar un contacto existente
        composable("crearperfil/{contactId}") { backStackEntry ->
            val contactId = backStackEntry.arguments?.getString("contactId")?.toLong() ?: 0L
            viewModel.setIdProfile(contactId) // Establece el ID del contacto en el ViewModel
            ProfileView(navController, viewModel)
        }
    }
}

