package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {
   val todoDau  = MainApplication.todoDatabase.getTodoDao()
    val todoList : LiveData<List<Todo>> = todoDau.getAllTodo()


    fun addTodo(title: String){
        viewModelScope.launch(Dispatchers.IO) {
            todoDau.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))
        }
    }
    fun deleteTodo(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            todoDau.deleteTodo(id)
        }
    }
}