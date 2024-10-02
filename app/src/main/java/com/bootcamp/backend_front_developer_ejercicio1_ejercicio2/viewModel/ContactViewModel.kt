package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.model.Contact
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val contactRepository: ContactRepository
) : ViewModel() {
    private val _contactList = MutableStateFlow<List<Contact>>(emptyList())
    val contactList: StateFlow<List<Contact>> = _contactList

    private val _selectedContact = MutableStateFlow<Contact?>(null)
    val selectedContact: StateFlow<Contact?> = _selectedContact

    fun getAllContact() {
        viewModelScope.launch {
            contactRepository.getALLContact()
                .collect { contacs ->
                _contactList.value = contacs
            }
        }
    }

    fun getContactById(id:Long){
        viewModelScope.launch {
            contactRepository.getContactById(id).collect{contact->
                _selectedContact.value = contact
            }
        }
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