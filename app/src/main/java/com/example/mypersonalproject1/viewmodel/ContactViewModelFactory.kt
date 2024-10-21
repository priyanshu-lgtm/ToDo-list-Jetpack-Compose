package com.example.mypersonalproject1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mypersonalproject1.ContactRepository

class ContactViewModelFactory(private val repository: ContactRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewmodle::class.java)) {
            return ContactViewmodle(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
