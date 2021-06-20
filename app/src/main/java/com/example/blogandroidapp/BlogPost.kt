package com.example.blogandroidapp

data class BlogPost(val image: String = "DEFAULT URL",
                    val title: String = "DEFAULT TITLE",
                    val userName: String = "DEFAULT AUTHOR",
                    val desc: String = "DEFAULT DESCRIPTION",
                    val time: String = "DEFAULT TIME",
                    val date: String = "DEFAULT DATE")
