package com.gonzalez.blanchard.statesexample.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

//ESTADO LOCAL

@Composable
fun TextInputDemo(){
    var text by remember {
        mutableStateOf("")
    }

    Column {
        TextField(value = text,
            onValueChange = { text = it},
            label = { Text(text = "Ingrese un texto")}
            )

        Text("Texto ingresado: $text")
    }
}