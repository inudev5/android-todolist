package devinu33.udemy.todocompose.data.models


import androidx.compose.ui.graphics.Color
import devinu33.udemy.todocompose.ui.theme.HighPriorityColor
import devinu33.udemy.todocompose.ui.theme.LowPriorityColor
import devinu33.udemy.todocompose.ui.theme.MediumPriorityColor
import devinu33.udemy.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor);
}
