package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.model.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDataBase: RoomDatabase(){
    abstract fun contactDao():ContactDao
}