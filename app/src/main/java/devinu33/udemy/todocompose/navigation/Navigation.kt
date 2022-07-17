package devinu33.udemy.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import devinu33.udemy.todocompose.navigation.destinations.listComposable
import devinu33.udemy.todocompose.navigation.destinations.taskComposable
import devinu33.udemy.todocompose.ui.viewmodels.SharedViewModel
import devinu33.udemy.todocompose.util.Constants.LIST_SCREEN


@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
){
    val screen = remember(navController){
        Screens(navController)
    }
    NavHost(navController = navController, startDestination = LIST_SCREEN){
        listComposable(navigateToTaskScreen = screen.task, sharedViewModel)
        taskComposable (navigateToListScreen = screen.list)
    }
}