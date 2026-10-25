package com.example.nesterenko.lab_1ml.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nesterenko.lab_1ml.model.Book
import com.example.nesterenko.lab_1ml.ui.components.BookCard
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.nesterenko.lab_1ml.R
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
@Composable
fun BookList(books: List<Book>, onBookClick: (Int) -> Unit, modifier: Modifier = Modifier)
{
    if(books.isEmpty())
    {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = stringResource(R.string.empty_books)
            )
        }
    }
    else
    {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(books,
                key = {book -> book.id}) {book ->
                BookCard(book = book, onClick = {onBookClick(book.id)})
            }


        }
    }
}