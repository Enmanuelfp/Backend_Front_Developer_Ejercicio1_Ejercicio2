package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo("nombre")
    var nombre: String,
    @ColumnInfo("telefon")
    var telefono:String,
    @ColumnInfo("correo")
    var correo:String,
    @ColumnInfo("imagenPerfil")
    var imagenPerfil:String,
    @ColumnInfo("fechaNacimiento")
    var fechaNacimiento:String
)
