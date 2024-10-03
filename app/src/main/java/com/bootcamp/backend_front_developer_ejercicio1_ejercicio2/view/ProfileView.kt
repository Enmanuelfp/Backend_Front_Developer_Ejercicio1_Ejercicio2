package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.R
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.component.InputText
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.model.Contact
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.viewModel.ContactViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileView(navController: NavController, viewModel: ContactViewModel) {
    val idTemp by viewModel.idProfile.collectAsState()

    val nombre = remember { mutableStateOf("") }
    val telefono = remember { mutableStateOf("") }
    val correo = remember { mutableStateOf("") }
    val imagenPerfil = remember { mutableStateOf("") }
    val fechaNacimiento = remember { mutableStateOf("") }

    if (idTemp != 0L) {
        val contactFlow = viewModel.getContactById(idTemp).collectAsState(initial = null)
        contactFlow.value?.let { contact ->
            if (nombre.value.isEmpty() && telefono.value.isEmpty() &&
                correo.value.isEmpty() && imagenPerfil.value.isEmpty() &&
                fechaNacimiento.value.isEmpty()) {
                nombre.value = contact.nombre
                telefono.value = contact.telefono
                correo.value = contact.correo
                imagenPerfil.value = contact.imagenPerfil
                fechaNacimiento.value = contact.fechaNacimiento
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.agregar_contacto),
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
                .background(Color.White)
                .padding(16.dp),  // Se asegura de que haya un relleno alrededor de todo el contenido
            verticalArrangement = Arrangement.Top,  // Alinea los elementos al inicio verticalmente
            horizontalAlignment = Alignment.CenterHorizontally // Centrado horizontalmente
        ) {

            val texto = if (idTemp == 0L) {
                stringResource(R.string.ingresar_datos)
            } else {
                stringResource(R.string.actualizar_contacto)
            }

            Text(
                text = texto,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 16.dp)  // Espacio entre el texto y los campos de entrada
            )

            // Campos de entrada
            InputText(
                hint = stringResource(R.string.nombre_hint),
                onValueChange = {
                    nombre.value = it
                },
                value = nombre.value
            )

            InputText(
                hint = stringResource(R.string.telefono_hint),
                onValueChange = {
                    telefono.value = it
                },
                value = telefono.value
            )

            InputText(
                hint = stringResource(R.string.correo_hint),
                onValueChange = {
                    correo.value = it
                },
                value = correo.value
            )

            InputText(
                hint = stringResource(R.string.imagen_hint),
                onValueChange = {
                    imagenPerfil.value = it
                },
                value = imagenPerfil.value
            )

            InputText(
                hint = stringResource(R.string.fecha_nacimiento_hint),
                onValueChange = {
                    fechaNacimiento.value = it
                },
                value = fechaNacimiento.value
            )

            // Botón para guardar
            Button(
                onClick = {
                    val contact = Contact(
                        id = idTemp,
                        nombre = nombre.value,
                        telefono = telefono.value,
                        correo = correo.value,
                        imagenPerfil = imagenPerfil.value,
                        fechaNacimiento = fechaNacimiento.value
                    )

                    if (idTemp == 0L) {
                        viewModel.addContact(contact)
                    } else {
                        viewModel.updateContact(contact)
                    }
                    navController.navigate("home")
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(stringResource(R.string.guardar_contacto))
            }
        }
    }
}
