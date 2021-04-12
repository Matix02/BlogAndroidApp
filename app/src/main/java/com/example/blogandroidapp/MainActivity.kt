package com.example.blogandroidapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: BlogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView: RecyclerView = findViewById(R.id.blog_list)

        adapter = BlogAdapter(this)

        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter

        val dummnyList = mutableListOf<BlogPost>()
        dummnyList.add(BlogPost("https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Flat_tick_icon.svg/1200px-Flat_tick_icon.svg.png",
        "Cos tam", "Ja","ASdjaskjjdaksdjkas", "2:10 PM", "Wednesday, March 10, 2021"))

        adapter.setListData(dummnyList)

        adapter.notifyDataSetChanged()

//        //DATABASE SECTION //
//        val database = FirebaseDatabase.getInstance()
//        val myRef = database.getReference("message")
//
//        myRef.setValue("Hello, World!")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mainList -> {
                true
            }
            R.id.contact -> {
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}