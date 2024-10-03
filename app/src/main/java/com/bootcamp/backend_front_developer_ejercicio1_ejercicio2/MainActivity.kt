package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.navigate.NavManager
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.ui.theme.Backend_Front_Developer_Ejercicio1_Ejercicio2Theme
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.view.HomeView
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.viewModel.ContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Backend_Front_Developer_Ejercicio1_Ejercicio2Theme {
                    NavManager()
            }
        }
    }
}

