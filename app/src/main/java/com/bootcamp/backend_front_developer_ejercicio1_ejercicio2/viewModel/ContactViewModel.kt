package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.model.Contact
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val contactRepository: ContactRepository
) : ViewModel() {

    private val _idProfile = MutableStateFlow(0L)
    val idProfile: StateFlow<Long> = _idProfile

    fun setIdProfile(id: Long) {
        _idProfile.value = id
    }

    fun getAllContact():Flow<List<Contact>> {
           return contactRepository.getALLContact()
    }

    fun getContactById(id: Long):Flow<Contact>{
            return contactRepository.getContactById(id)
    }

    fun addContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.addContact(contact)
        }
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.updateContact(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.deleteContact(contact)
        }
    }


}