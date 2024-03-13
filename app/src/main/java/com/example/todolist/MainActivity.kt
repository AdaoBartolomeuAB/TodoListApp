package com.example.todolist


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R.id.btnAddTodo
import com.example.todolist.R.id.etTodoTitle
import com.example.todolist.R.id.tvTodoTitle

class MainActivity : AppCompatActivity() {

    lateinit var todoAdpater: TodoAdpater
    lateinit var rvTodoItems: RecyclerView
    lateinit var btnAddTodo: Button
    lateinit var btnDeleteDoneTodo: Button
    lateinit var etTodoTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdpater = TodoAdpater(mutableListOf())
        rvTodoItems = findViewById(R.id.rvTodoItems)
        rvTodoItems.adapter = todoAdpater
        rvTodoItems.layoutManager = LinearLayoutManager(this)
        btnAddTodo = findViewById(R.id.btnAddTodo)
        btnDeleteDoneTodo = findViewById(R.id.btnDeleteDoneTodo)
        etTodoTitle = findViewById(R.id.etTodoTitle)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle);
                todoAdpater.addTodo(todo)
                etTodoTitle.setText("")
            }
        }

        btnDeleteDoneTodo.setOnClickListener {
            todoAdpater.deleteDoneTodo()
        }
    }
}