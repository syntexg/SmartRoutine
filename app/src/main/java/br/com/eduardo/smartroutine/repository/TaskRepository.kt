package br.com.eduardo.smartroutine.repository

import android.content.ContentValues
import android.content.Context
import br.com.eduardo.smartroutine.model.Task
import br.com.eduardo.smartroutine.model.TaskDAO

class TaskRepository(context: Context) {
    companion object {
        private val table_name = "tasks"
    }

    val db = TaskDAO(context).writableDatabase

    fun insert(task: Task): Long {
        val contentValues = ContentValues().apply {
            put("task", task.task)
            put("description", task.description)
        }
        return db.insert(table_name, "", contentValues)
    }
}