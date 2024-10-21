package com.example.mypersonalproject1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contacts (
    val name : String,
    val lastName : String,
    val phoneNumber : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int
)