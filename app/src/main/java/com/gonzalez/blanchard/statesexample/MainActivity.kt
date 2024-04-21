package com.gonzalez.blanchard.statesexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.gonzalez.blanchard.statesexample.ui.theme.StatesExampleTheme
import com.gonzalez.blanchard.statesexample.ui.views.CounterScreen
import com.gonzalez.blanchard.statesexample.ui.views.NewsFeedScreen
import com.gonzalez.blanchard.statesexample.ui.views.ParentStateView
import com.gonzalez.blanchard.statesexample.ui.views.TextInputDemo
import com.gonzalez.blanchard.statesexample.viewmodels.MainViewModel
import com.gonzalez.blanchard.statesexample.viewmodels.NewsViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelNews: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModelNews = ViewModelProvider(this)[NewsViewModel::class.java]

        setContent {
            StatesExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val isVisible = remember { mutableStateOf(false) }

                    Column(Modifier.fillMaxSize()) {
                        Text(text = "Estado Local")
                        TextInputDemo()

                        Text(text = "Estado Compartido")
                        CounterScreen(viewModel = viewModel)

                        Text(text = "Estado Levantado")
                        ParentStateView(isDialogVisible = isVisible)
                        
                        Text(text = "Estado Externo")
                        NewsFeedScreen(viewModel = viewModelNews)
                    }


                }
            }
        }
    }
}
