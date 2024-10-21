package com.example.mypersonalproject1

import com.example.mypersonalproject1.model.Contacts
import com.example.mypersonalproject1.model.ContactsDao
import kotlinx.coroutines.flow.Flow

class ContactRepository(private var dao: ContactsDao) {

    val constactList : Flow<List<Contacts>> = dao.getList()

    suspend fun insertContact(contact: Contacts) {
        dao.insertContact(contact)
    }

    suspend fun deleteContact(contact: Contacts) {
        dao.deleteContact(contact)
    }
}