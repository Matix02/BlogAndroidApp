package com.example.blogandroidapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseRepository {

    fun getBlogData():LiveData<MutableList<BlogPost>> {
        val mutableData = MutableLiveData<MutableList<BlogPost>>()

        FirebaseDatabase.getInstance().getReference("Blogs").orderByChild("counter").addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val listData: ArrayList<BlogPost> = ArrayList()

                for(i in snapshot.children) {
                    val postAuthor: String = i.getValue(BlogPost::class.java)?.userName ?: "Autor"
                    val postTitle: String = i.getValue(BlogPost::class.java)?.title ?: "Tytuł"
                    val postImg: String = i.getValue(BlogPost::class.java)?.image ?: "Obrazek"
                    val postTime: String = i.getValue(BlogPost::class.java)?.time ?: "Czas"
                    val postDate: String = i.getValue(BlogPost::class.java)?.date ?: "Data"
                    val postDescription: String = i.getValue(BlogPost::class.java)?.desc ?: "Opis"

                    val blogPost = BlogPost(postImg, postTitle, postAuthor,postDescription,postTime, postDate)

                    listData.add(blogPost)
                    Log.e("firebase", "Error getting data = $i")
                }
             mutableData.value = listData
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("firebase", "Error getting data = $error")
            }
        })
        return mutableData
    }
}