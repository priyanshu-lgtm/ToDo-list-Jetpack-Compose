package com.example.mypersonalproject1.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(text : String,modifire : Modifier,size : Int){

    Text(text,
        modifier = Modifier,
        style = TextStyle(fontSize = size.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Normal)
        )

}