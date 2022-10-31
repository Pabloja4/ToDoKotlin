package com.app.ejercicio_ciclo4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.app.ejercicio_ciclo4.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ToDoFragment : Fragment(){

    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter: RecyclerView.Adapter<MyTaskListAdapter.MyViewHolder>
    var myTaskTitles: ArrayList<String?> = ArrayList()
    var myTaskTimes: ArrayList<String?> = ArrayList()
    var myTaskPlaces: ArrayList<String?> = ArrayList()
    var info: Bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento= inflater.inflate(R.layout.fragment_to_do, container, false)

        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fab: View = requireActivity().findViewById(R.id.fabToDo)
        fab.setOnClickListener {view->
            val intent = Intent(activity, NewTaskActivity::class.java)
            var requestCode = 0
            startActivityForResult(intent,requestCode)
        }
        var info: Bundle = Bundle()
        info.putStringArrayList("titles", myTaskTitles)
        info.putStringArrayList("times", myTaskTimes)
        info.putStringArrayList("places", myTaskPlaces)

        listRecyclerView = requireView().findViewById(R.id.recyclerToDoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity, info)

        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        updateList()

//        var myTaskTitles: ArrayList<String> = ArrayList()
//
//        myTaskTitles.add(resources.getString(R.string.body_text))
//        myTaskTitles.add(resources.getString(R.string.body_text))
//        myTaskTitles.add(resources.getString(R.string.body_text))
//
//        var myTaskTimes: ArrayList<String> = ArrayList()
//        myTaskTimes.add("10:30")
//        myTaskTimes.add("14:30")
//        myTaskTimes.add("20:00")
//
//        var myTaskPlaces: ArrayList<String> = ArrayList()
//        myTaskPlaces.add("Exito")
//        myTaskPlaces.add("D1")
//        myTaskPlaces.add("Olimpica")
//
//        var info: Bundle = Bundle()
//        info.putStringArrayList("titles", myTaskTitles)
//        info.putStringArrayList("times", myTaskTimes)
//        info.putStringArrayList("places", myTaskPlaces)
//
//        listRecyclerView = requireView().findViewById(R.id.recyclerToDoList)
//        myAdapter = MyTaskListAdapter(activity as AppCompatActivity, info)
//
//        listRecyclerView.setHasFixedSize(true)
//        listRecyclerView.adapter = myAdapter
//        listRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

    }


    fun updateList(){
        val db = ToDoDatabase.getDatabase(requireActivity())
        val toDoDao = db.todoDao()
        runBlocking {
            launch {
                var result = toDoDao.getAllTasks()
                var i = 0
                myTaskTitles.clear()
                myTaskTimes.clear()
                myTaskPlaces.clear()

                while (i< result.size){
                    myTaskTitles.add(result[i].title.toString())
                    myTaskTimes.add(result[i].time.toString())
                    myTaskPlaces.add(result[i].place.toString())
                    i++
                }
                myAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        if(requestCode == 0){
            if(resultCode== Activity.RESULT_OK)
                updateList()

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}