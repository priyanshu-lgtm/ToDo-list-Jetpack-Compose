package com.example.mypersonalproject1.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypersonalproject1.ContactRepository
import com.example.mypersonalproject1.model.Contacts
import kotlinx.coroutines.launch

class ContactViewmodle(private var repository: ContactRepository):ViewModel() {
    val contactList = repository.constactList

    suspend fun addContact(contacts: Contacts){
        viewModelScope.launch {
            repository.insertContact(contact = contacts)
        }
    }

    suspend fun deleteContact(contacts: Contacts){
        viewModelScope.launch {
            repository.deleteContact(contact = contacts)
        }
    }

}