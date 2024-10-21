package com.example.mypersonalproject1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.mypersonalproject1.components.ContactCard
import com.example.mypersonalproject1.components.CustomText
import com.example.mypersonalproject1.viewmodel.ContactViewmodle
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: ContactViewmodle) {

    val contact by viewModel.contactList.collectAsState(emptyList())
    var delete by remember{ mutableStateOf(false)}
    var coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    CustomText("TO DO", modifire = Modifier,15)
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "delete",
                        modifier = Modifier.padding(end = 16.dp).clickable {
                            delete = !delete
                        })
                }
            )
        }

    ) {
        Column(
            Modifier.wrapContentSize().background(Color.White).padding(top = it.calculateTopPadding())
                .statusBarsPadding()
        ) {
            LazyColumn(Modifier.wrapContentHeight().padding(16.dp)){
                items(contact){contacts ->
                    ContactCard(contacts, delete = delete){contact ->
                        if(delete){
                            coroutineScope.launch {
                                viewModel.deleteContact(contact)
                            }
                        }else{

                        }
                    }
                }
            }
            Button(onClick = {
                navController.navigate("FirstScreen")
            },content = { Text("Add contact") }, modifier = Modifier.align(Alignment.CenterHorizontally))
        }

    }
}