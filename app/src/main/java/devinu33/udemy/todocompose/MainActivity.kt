package devinu33.udemy.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import devinu33.udemy.todocompose.navigation.SetupNavigation
import devinu33.udemy.todocompose.ui.theme.TodoComposeTheme
import devinu33.udemy.todocompose.ui.theme.Typography
import devinu33.udemy.todocompose.ui.viewmodels.SharedViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController:NavHostController
    private val sharedViewModel:SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoComposeTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController, sharedViewModel)

            }
        }
    }
}

