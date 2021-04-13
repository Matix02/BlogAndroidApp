package com.example.blogandroidapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlogViewModel : ViewModel() {

    private val repo = FirebaseRepository()
    fun fetchBlogData(): LiveData<MutableList<BlogPost>>{
        val mutableData = MutableLiveData<MutableList<BlogPost>>()
        repo.getBlogData().observeForever() { blogList ->
            mutableData.value = blogList
        }
        return mutableData
    }
}