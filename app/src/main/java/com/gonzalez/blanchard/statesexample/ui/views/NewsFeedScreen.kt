package com.gonzalez.blanchard.statesexample.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.gonzalez.blanchard.statesexample.ui.data.News
import com.gonzalez.blanchard.statesexample.viewmodels.NewsViewModel

@Composable
fun NewsFeedScreen(viewModel: NewsViewModel){
    val newsList by remember {
        viewModel.newsFlow
    }.collectAsState(initial = emptyList())

    LazyColumn {
        items(newsList){news ->
            NewsItem(news = news)
        }
    }

}

@Composable
fun NewsItem(news: News){
    Column {
        Text(text = news.title)
        Text(text = news.content)
        //IMPLEMENTAR LA CARGA DE IMAGEN
    }
}
