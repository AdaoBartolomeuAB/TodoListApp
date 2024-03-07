package com.example.todolist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoAdpater(  private val todos: MutableList<Todo>):RecyclerView.Adapter<TodoAdpater.TodoViewHolder>() {

    class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}