package com.app.ejercicio_ciclo4

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.app.ejercicio_ciclo4.room_database.ToDo
import com.app.ejercicio_ciclo4.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NewTaskActivity : AppCompatActivity() {
    lateinit var editTextTitle: EditText
    lateinit var editTextTime: EditText
    lateinit var editTextPlace: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        editTextTitle = findViewById(R.id.editTextTitle)
        editTextTime = findViewById(R.id.editTextTime)
        editTextPlace = findViewById(R.id.editTextPlace)
    }

    fun onSave(view: View){
        var title: String = editTextTitle.text.toString()
        var time: String = editTextTime.text.toString()
        var place: String = editTextPlace.text.toString()
        val db = ToDoDatabase.getDatabase(this)
        val toDoDao = db.todoDao()

        val task = ToDo(0, title, time, place)


        runBlocking {
            launch {



                    var result = toDoDao.insertTask(task)
                    if(result!= -1L){
                        setResult(Activity.RESULT_OK)
                        finish()
                    }


            }
        }

    }




}