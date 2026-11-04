package com.example.myfirstmobileapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    // 获取数据库的 DAO
    private val dao = AppDatabase.getDatabase(application).taskDao()

    // 将数据库的 Flow 转换为 UI 可观察的 StateFlow
    val tasks: StateFlow<List<Task>> = dao.getAllTasks()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // 添加任务
    fun addTask(title: String) {
        viewModelScope.launch {
            dao.insertTask(Task(title = title))
        }
    }

    // 切换完成状态
    fun toggleTaskStatus(task: Task) {
        viewModelScope.launch {
            dao.updateTask(task.copy(isDone = !task.isDone))
        }
    }

    // 删除任务
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            dao.deleteTask(task)
        }
    }

    // 撤销删除（重新插入）
    fun undoDeleteTask(task: Task) {
        viewModelScope.launch {
            // 插入时把 id 归零，让数据库重新生成 id，避免主键冲突
            dao.insertTask(task.copy(id = 0))
        }
    }
}