package com.app.ejercicio_ciclo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class ToDoActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration:AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
//        if(savedInstanceState==null){
//            supportFragmentManager.beginTransaction()
//                .setReorderingAllowed(true)
//                .add(R.id.fcvToDo, ToDoFragment::class.java, null, "todo")
//                .commit()
//
//        }
        setSupportActionBar(findViewById(R.id.my_toolbar))
        val fab: View = findViewById(R.id.fabToDo)
        fab.setOnClickListener {view->}
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fcvToDo) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration= AppBarConfiguration(setOf(R.id.nav_todo, R.id.nav_about), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController) }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.fcvToDo) as NavHostFragment
        val navController=navHostFragment.navController
        return navController.navigateUp(appBarConfiguration)|| super.onSupportNavigateUp()
    }

    }
