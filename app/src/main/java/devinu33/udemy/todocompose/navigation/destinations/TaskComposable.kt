package devinu33.udemy.todocompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import devinu33.udemy.todocompose.util.Action
import devinu33.udemy.todocompose.util.Constants.LIST_ARGUMENT_KEY
import devinu33.udemy.todocompose.util.Constants.LIST_SCREEN
import devinu33.udemy.todocompose.util.Constants.TASK_ARGUMENT_KEY
import devinu33.udemy.todocompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(navigateToListScreen:(Action)->Unit){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type= NavType.IntType
        })
    ){

    }
}

