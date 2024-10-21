package com.example.mypersonalproject1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mypersonalproject1.model.Contacts
import com.example.mypersonalproject1.model.ContactsDao

@Database(entities = [Contacts::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract val dao : ContactsDao

    companion object
    {
        private var Instance: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            return Instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "ContactDatabase"
                ).build()
                Instance = instance
                return instance
            }

        }
    }

}