package com.example.nesterenko.lab_1ml.ui

import com.example.nesterenko.lab_1ml.model.Book


data class BookListUiState(
    val books: List<Book> = emptyList()
)


