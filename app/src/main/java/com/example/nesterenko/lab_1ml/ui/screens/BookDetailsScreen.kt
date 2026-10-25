package com.example.nesterenko.lab_1ml.ui.screens
import com.example.nesterenko.lab_1ml.model.Book
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button

@Composable
fun BookDetailsScreen(
    book: Book?,
    onToggleRead: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (book == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Книгу не знайдено")
        }

        return
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement =
            Arrangement.spacedBy(12.dp)
    ) {
        TextButton(
            onClick = onBack
        ) {
            Text("Назад")
        }

        Text(
            text = book.title,
            style =
                MaterialTheme.typography.headlineMedium
        )

        Text(
            text = book.author,
            style =
                MaterialTheme.typography.titleMedium
        )

        book.description?.let {
            Text(it)
        }

        Text(
            text = if (book.isRead) {
                "Прочитано"
            } else {
                "Не прочитано"
            }
        )

        Button(
            onClick = onToggleRead
        ) {
            Text(
                if (book.isRead) {
                    "Позначити непрочитаною"
                } else {
                    "Позначити прочитаною"
                }
            )
        }
    }


}



