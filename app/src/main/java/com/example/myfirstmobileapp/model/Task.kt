package com.example.myfirstmobileapp.model

data class Task(
    val id: Long = System.nanoTime(),
    val title: String,
    val isDone: Boolean = false
)