package devinu33.udemy.todocompose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import devinu33.udemy.todocompose.data.models.TodoTask
import devinu33.udemy.todocompose.data.repositories.TodoRepository
import devinu33.udemy.todocompose.util.SearchAppBarState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val todoRepository: TodoRepository) :
    ViewModel() {
    val searchAppBarState: MutableState<SearchAppBarState> = mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState:MutableState<String> = mutableStateOf("")
    private val _allTasks = MutableStateFlow<List<TodoTask>>(emptyList())
    val allTasks:StateFlow<List<TodoTask>> = _allTasks
    fun getAllTasks(){
        viewModelScope.launch {
            todoRepository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }
}