package com.example.naruto

data class Questions (
    val id: Int,
    val question: String,
    val image: Int,
    val optionone: String,
    val optiontwo: String,
    val optionthree: String,
    val optionfour: String,
    val correctans: Int
)
