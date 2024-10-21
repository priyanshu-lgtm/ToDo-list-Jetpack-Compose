package com.example.mypersonalproject1.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {

    @Upsert
    suspend fun insertContact(contacts: Contacts)

    @Delete
    suspend fun deleteContact(contacts: Contacts)

    @Query("SELECT * FROM CONTACTS")
    fun getList(): Flow<List<Contacts>>
}