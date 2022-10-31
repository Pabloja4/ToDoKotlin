package com.app.ejercicio_ciclo4.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase


@Database(entities = arrayOf(ToDo::class), version=1)

abstract class ToDoDatabase: RoomDatabase(){

    abstract fun todoDao(): ToDoDao

    companion object {

        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase{

            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                ToDoDatabase::class.java, "ToDoDatabase").build()
                INSTANCE = instance

                instance


            }
        }

    }

}

