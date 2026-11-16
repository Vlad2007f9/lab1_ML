package com.example.nesterenko.lab_1ml.data

import com.example.nesterenko.lab_1ml.data.local.BookEntity
import com.example.nesterenko.lab_1ml.model.Book

fun BookEntity.toBook() : Book =
    Book (
        id = id,
        title = title,
        author = author,
        description = description,
        isRead = isRead
    )

fun Book.toEntity() : BookEntity =
    BookEntity(
        id = id,
        title = title,
        author = author,
        description = description,
        isRead = isRead
    )