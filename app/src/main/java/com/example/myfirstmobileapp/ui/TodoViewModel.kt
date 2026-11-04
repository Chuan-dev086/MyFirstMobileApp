package com.example.myfirstmobileapp.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.myfirstmobileapp.model.Task

class TodoViewModel : ViewModel() {
    val tasks = mutableStateListOf<Task>()

    fun add(title: String) {
        val text = title.trim()
        if (text.isNotEmpty()) {
            tasks.add(Task(title = text))
        }
    }

    fun toggle(task: Task) {
        val index = tasks.indexOf(task)
        if (index >= 0) {
            tasks[index] = task.copy(isDone = !task.isDone)
        }
    }

    fun delete(task: Task): Int {
        val index = tasks.indexOf(task)
        if (index >= 0) tasks.removeAt(index)
        return index
    }

    fun restore(task: Task, index: Int) {
        tasks.add(index.coerceAtMost(tasks.size), task)
    }
}