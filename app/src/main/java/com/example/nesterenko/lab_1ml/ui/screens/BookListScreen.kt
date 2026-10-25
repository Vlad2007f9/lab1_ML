package com.example.nesterenko.lab_1ml.ui.screens
import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import com.example.nesterenko.lab_1ml.model.Book
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(
    books: List<Book>,
    onBookClick: (Int) -> Unit,
    onAddBook: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Мої книги")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddBook
            ) {
                Text("+")
            }
        }
    ) { innerPadding ->
        BookList(
            books = books,
            onBookClick = onBookClick,
            modifier = Modifier.padding(
                innerPadding
            )
        )
    }
}
