package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.model.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setContact(item:Contact)

    @Query("SELECT * FROM contactos")
    fun getContact(): Flow<List<Contact>>

    @Query("SELECT * FROM contactos WHERE ID = :id")
    fun getContactById(id: Long): Flow<Contact>


    @Update
    suspend fun updateContact(item: Contact)

    @Delete
    suspend fun deleteContact(item: Contact)
}