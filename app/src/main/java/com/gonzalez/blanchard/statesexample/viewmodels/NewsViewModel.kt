package com.gonzalez.blanchard.statesexample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.statesexample.ui.data.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel(){
    private val _newsFlow = MutableStateFlow(generateFakeNews())
    val newsFlow = _newsFlow.asStateFlow()

    init {
        viewModelScope.launch {
            while (true){
                _newsFlow.value = generateFakeNews()
                delay(5000)
            }
        }
    }

    private fun generateFakeNews(): List<News>{
        return listOf(
            News(title = "Noticia 1", content = "Contenido de la noticia 1 aaaa", imageUrl = "https://picsum.photos/200"),
            News(title = "Noticia 2", content = "Contenido de la noticia 2 bbb", imageUrl = "https://picsum.photos/201"),
            News(title = "Noticia 3", content = "Contenido de la noticia 3 ccc", imageUrl = "https://picsum.photos/202")
        )
    }

}