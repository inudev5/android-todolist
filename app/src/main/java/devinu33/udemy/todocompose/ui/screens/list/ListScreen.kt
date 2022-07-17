package devinu33.udemy.todocompose.ui.screens.list

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import devinu33.udemy.todocompose.R
import devinu33.udemy.todocompose.data.models.TodoTask
import devinu33.udemy.todocompose.ui.theme.fabBackgroundColor
import devinu33.udemy.todocompose.ui.viewmodels.SharedViewModel
import devinu33.udemy.todocompose.util.SearchAppBarState
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true){
        sharedViewModel.getAllTasks()
    }
    val allTasks:List<TodoTask> by sharedViewModel.allTasks.collectAsState()
    for (task in allTasks) {Log.d("task","${task.title}")}
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState//observing
    val searchTextState: String by sharedViewModel.searchTextState
    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            ListContent(
                tasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen
            )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(onFabClicked: (taskId: Int) -> Unit) {
    FloatingActionButton(
        onClick = { onFabClicked(-1) },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) { //create new one, pass taskId -1
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.White
        )
    }
}

