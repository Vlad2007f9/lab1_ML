package com.example.nesterenko.lab_1ml.ui.components
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.nesterenko.lab_1ml.model.Book
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.nesterenko.lab_1ml.R

@Composable
fun BookCard(book: Book, onClick: () -> Unit, modifier:Modifier = Modifier)
{
    Card( onClick = onClick,  modifier = modifier.fillMaxWidth())
    {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp))
        {
            Text(
                text = book.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = book.author,
                style = MaterialTheme.typography.bodyMedium)

            book.description?.let{description ->
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Text(
                text = if(book.isRead)
                {
                    stringResource(R.string.status_read)
                }
                else
                {
                    stringResource(R.string.status_not_read)
                },
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}