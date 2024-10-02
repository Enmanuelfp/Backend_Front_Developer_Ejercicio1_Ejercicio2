package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo("nombre")
    val nombre: String,
    @ColumnInfo("telefon")
    val telefono:String,
    @ColumnInfo("correo")
    val correo:String,
    @ColumnInfo("imagenPerfil")
    val imagenPerfil:String,
    @ColumnInfo("fechaNacimiento")
    val fechaNacimiento:String
)
