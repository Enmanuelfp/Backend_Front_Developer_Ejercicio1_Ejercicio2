package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.repository

import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.model.Contact
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.room.ContactDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContactRepository @Inject constructor(private val contactDao: ContactDao){

    suspend fun addContact(contact: Contact) = contactDao.setContact(contact)
    suspend fun updateContact(contact: Contact) = contactDao.updateContact(contact)
    suspend fun deleteContact(contact: Contact) = contactDao.deleteContact(contact)
    fun getALLContact():Flow<List<Contact>> = contactDao.getContact().flowOn((Dispatchers.IO)).conflate()
    fun getContactById(id: Long): Flow<Contact> = contactDao.getContactById(id).flowOn(Dispatchers.IO).conflate()
}