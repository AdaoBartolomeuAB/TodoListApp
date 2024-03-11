package com.example.todolist

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdpater(  private val todos: MutableList<Todo>):RecyclerView.Adapter<TodoAdpater.TodoViewHolder>() {

    class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvTodoTitle: TextView
        val cdDone: CheckBox

        init {
            tvTodoTitle = itemView.findViewById(R.id.tvTodoTitle)
            cdDone = itemView.findViewById(R.id.cdDone)
        }
    }

    fun addTodo(todo: Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean){
        if (isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo,parent,false))
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.tvTodoTitle.text = curTodo.title
        holder.cdDone.isChecked = curTodo.isChecked
        toggleStrikeThrough(holder.tvTodoTitle,curTodo.isChecked)
        holder.cdDone.setOnCheckedChangeListener { _, isChecked ->
            toggleStrikeThrough( holder.tvTodoTitle,isChecked)
            holder.cdDone.isChecked = !curTodo.isChecked
        }
    }
}