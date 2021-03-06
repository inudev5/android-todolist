package devinu33.udemy.todocompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import devinu33.udemy.todocompose.ui.screens.list.ListScreen
import devinu33.udemy.todocompose.ui.viewmodels.SharedViewModel
import devinu33.udemy.todocompose.util.Constants.LIST_ARGUMENT_KEY
import devinu33.udemy.todocompose.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(navigateToTaskScreen: (taskId:Int) -> Unit, sharedViewModel: SharedViewModel){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type= NavType.StringType
        })
    ){
        ListScreen(navigateToTaskScreen = navigateToTaskScreen, sharedViewModel)
    }
}