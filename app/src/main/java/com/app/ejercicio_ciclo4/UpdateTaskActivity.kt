package com.app.ejercicio_ciclo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.ejercicio_ciclo4.room_database.ToDo
import com.app.ejercicio_ciclo4.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UpdateTaskActivity : AppCompatActivity() {
    lateinit var editTextTitle: EditText
    lateinit var editTextTime: EditText
    lateinit var editTextPlace: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_task)
        editTextTitle = findViewById(R.id.updateTextTitle)
        editTextTime = findViewById(R.id.updateTextTime)
        editTextPlace = findViewById(R.id.updateTextPlace)
    }



    fun onUpdate(view: View){
        var title: String = editTextTitle.text.toString()
        var time: String = editTextTime.text.toString()
        var place: String = editTextPlace.text.toString()
        val db = ToDoDatabase.getDatabase(this)
        val toDoDao = db.todoDao()
        val task = ToDo(taskId, title, time, place)

        runBlocking {
            launch {
                var result = toDoDao.insertTask(task)
                if(result!= -1L){
                    setResult(RESULT_OK)
                    finish()
                }

            }
        }

    }
}