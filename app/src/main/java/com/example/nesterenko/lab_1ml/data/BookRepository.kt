package com.example.nesterenko.lab_1ml.data

import com.example.nesterenko.lab_1ml.data.local.BookDao
import com.example.nesterenko.lab_1ml.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookRepository(
    private val bookDao: BookDao
) {
    fun observeBooks(): Flow<List<Book>> =
        bookDao
            .observeAll()
            .map {entities ->

                entities.map {
                    it.toBook()
                }
            }
    suspend fun addBook(
        book:Book
    ) {
        bookDao.insert(
            book.toEntity()
        )
    }

    suspend fun updateBook(
        book: Book
    ) {
        bookDao.update(
            book.toEntity()
        )
    }
}