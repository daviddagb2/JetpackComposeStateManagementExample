package com.gonzalez.blanchard.statesexample.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import com.gonzalez.blanchard.statesexample.viewmodels.MainViewModel

@Composable
fun CounterScreen(viewModel: MainViewModel){
    Column {
        Text("Contador: ${viewModel.count.value}")
        Button(onClick = {
            viewModel.incrementCount()
        }) {
            Text(text = "Incrementar")
        }
    }
}