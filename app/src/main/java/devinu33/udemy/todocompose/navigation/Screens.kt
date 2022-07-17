package devinu33.udemy.todocompose.navigation

import androidx.navigation.NavHostController
import devinu33.udemy.todocompose.util.Action

import devinu33.udemy.todocompose.util.Constants.LIST_SCREEN

class Screens(navController:NavHostController) {
    //navigation argument는 기본형만을 허용(Boolean, String, Int)
    val list:(Action)->Unit = {
        navController.navigate("list/${it.name}"){
            popUpTo(LIST_SCREEN){ inclusive=true} //Task->List로 갈때는 스택에서 제거함
        }
    }
    val task:(taskId:Int)->Unit = {
        navController.navigate("task/$it")
    }
}