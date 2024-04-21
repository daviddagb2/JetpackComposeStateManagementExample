package com.gonzalez.blanchard.statesexample.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun ParentStateView(isDialogVisible: MutableState<Boolean>){
    Column {
        Button(onClick = {
            isDialogVisible.value = true
        }) {
            Text(text = "Mostrar dialogo")
        }

        if(isDialogVisible.value){
            MyDialog(isDialogVisible)
        }
    }
}

@Composable
fun MyDialog(isDialogVisible: MutableState<Boolean>){
    Column {
        Text(text = "Dialogo")
        Button(onClick = {
            isDialogVisible.value = false
        }) {
            Text(text = "Cerrar")
        }
    }
}