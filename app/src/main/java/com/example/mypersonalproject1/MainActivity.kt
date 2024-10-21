package com.example.mypersonalproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mypersonalproject1.db.ContactDatabase
import com.example.mypersonalproject1.screens.FirstScreen
import com.example.mypersonalproject1.screens.HomeScreen
import com.example.mypersonalproject1.viewmodel.ContactViewModelFactory
import com.example.mypersonalproject1.viewmodel.ContactViewmodle

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ContactViewmodle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = ContactDatabase.getDatabase(this)
        val repository = ContactRepository(database.dao)

        val viewModelFactory = ContactViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[ContactViewmodle::class.java]


        enableEdgeToEdge()
        setContent {


            val navcontroller = rememberNavController()
            NavHost(navController = navcontroller, startDestination = "HomeScreen", builder = {
                composable("HomeScreen") {
                    HomeScreen(navcontroller, viewModel)
                }
                composable("FirstScreen") {
                    FirstScreen(navcontroller, viewModel)
                }
            })
        }
    }
}