package com.example.nesterenko.lab_1ml.model

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val description: String?,
    val isRead: Boolean) {
}