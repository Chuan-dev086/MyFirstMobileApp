package com.example.myfirstmobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstmobileapp.ui.theme.MyFirstMobileAppTheme
import kotlinx.coroutines.launch

data class Task(
    val id: Long = System.nanoTime(),
    val title: String,
    val isDone: Boolean = false
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstMobileAppTheme {
                TodoApp()
            }
        }
    }
}

@Composable
fun TodoApp() {
    var inputTask by remember { mutableStateOf("") }
    val taskList = remember { mutableStateListOf<Task>() }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = inputTask,
                    onValueChange = { inputTask = it },
                    label = { Text("Please type in TODOS") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                Button(
                    onClick = {
                        val text = inputTask.trim()
                        if (text.isNotEmpty()) {
                            taskList.add(Task(title = text))
                            inputTask = ""
                        }
                    },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("Add")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(taskList, key = { it.id }) { task ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = task.isDone,
                                onCheckedChange = { checked ->
                                    val index = taskList.indexOf(task)
                                    if (index >= 0) {
                                        taskList[index] = task.copy(isDone = checked)
                                    }
                                }
                            )

                            Text(
                                text = task.title,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 8.dp),
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                textDecoration = if (task.isDone) {
                                    TextDecoration.LineThrough
                                } else {
                                    TextDecoration.None
                                }
                            )

                            TextButton(
                                onClick = {
                                    val index = taskList.indexOf(task)
                                    if (index < 0) return@TextButton
                                    taskList.removeAt(index)

                                    scope.launch {
                                        val result = snackbarHostState.showSnackbar(
                                            message = "已删除: ${task.title}",
                                            actionLabel = "撤销",
                                            duration = SnackbarDuration.Long
                                        )
                                        if (result == SnackbarResult.ActionPerformed) {
                                            taskList.add(
                                                index.coerceAtMost(taskList.size),
                                                task
                                            )
                                        }
                                    }
                                }
                            ) {
                                Text("删除")
                            }
                        }
                    }
                }
            }
        }
    }
}