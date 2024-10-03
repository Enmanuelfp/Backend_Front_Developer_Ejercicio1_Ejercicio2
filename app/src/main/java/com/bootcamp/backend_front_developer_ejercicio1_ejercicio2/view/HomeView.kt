package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.R

import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.component.ProfileCard
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.viewModel.ContactViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, viewModel: ContactViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.contactos),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    Color.Blue
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(
                    Color.White
                )
        )
        {
            ShowContacts(viewModel,navController)
            BtnAdd(viewModel, navController)
        }
    }
}


@Composable
fun ShowContacts(viewModel: ContactViewModel,navController: NavController) {
    // Colecciona la lista de contactos desde el ViewModel
    val contacts by viewModel.getAllContact().collectAsState(emptyList())

    LazyColumn {
        items(contacts) { contact ->
            ProfileCard(
                name = contact.nombre,
                phoneNumber = contact.telefono,
                email = contact.correo,
                profileImage = contact.imagenPerfil,
                birthdate = contact.fechaNacimiento,
                onEdit = {viewModel.setIdProfile(contact.id)
                    navController.navigate("crearperfil/${contact.id}")},
                onDelete = {viewModel.deleteContact(contact)}
            )
        }
    }
}

@Composable
fun BtnAdd(viewModel: ContactViewModel, navController: NavController) {
    // Ubicación y diseño del botón
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            modifier = Modifier.
            align(Alignment.BottomEnd).padding(end = 10.dp),
            onClick = {
                navController.navigate("crearPerfil")
            },
            containerColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
    }

}

