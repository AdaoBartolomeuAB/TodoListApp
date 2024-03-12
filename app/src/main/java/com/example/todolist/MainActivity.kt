package com.example.todolist


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R.id.tvTodoTitle

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdpater: TodoAdpater
    lateinit  var rvTodoItems: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdpater = TodoAdpater(mutableListOf())
        rvTodoItems.adapter = todoAdpater
    }
}