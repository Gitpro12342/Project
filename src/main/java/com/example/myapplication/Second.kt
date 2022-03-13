package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Second(viewModel: Jeck = hiltViewModel()){
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = viewModel.text , fontSize = 60.sp)
        inputText()
    }
}
@Composable
fun inputText(viewModel: Jeck = hiltViewModel()){
    TextField(value = viewModel.text, onValueChange = { viewModel.text = it})
}
@Preview
@Composable
fun PreviewHome(){
    Main()
}