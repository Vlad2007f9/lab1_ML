package com.example.nesterenko.lab_1ml.data

import android.content.Context
import androidx.room3.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import com.example.nesterenko.lab_1ml.data.local.AppDatabase

class AppContainer(
    context: Context
) {
    private val database =
        Room.databaseBuilder<AppDatabase>(
            context.applicationContext,
            "book_tracker.db"
        )
            .setDriver(
                AndroidSQLiteDriver()
            )
            .build()

    val bookRepository =
        BookRepository(
            bookDao = database.bookDao()
        )
}













