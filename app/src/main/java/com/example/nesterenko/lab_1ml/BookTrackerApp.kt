package com.example.nesterenko.lab_1ml
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.nesterenko.lab_1ml.model.Book
import com.example.nesterenko.lab_1ml.ui.screens.BookList
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.nesterenko.lab_1ml.ui.screens.AddBookForm
import androidx.compose.material3.FloatingActionButton
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.nesterenko.lab_1ml.navigation.AddBookRoute
import com.example.nesterenko.lab_1ml.navigation.BookDetailsRoute
import com.example.nesterenko.lab_1ml.navigation.BookListRoute
import com.example.nesterenko.lab_1ml.ui.screens.AddBookScreen
import com.example.nesterenko.lab_1ml.ui.screens.BookDetailsScreen
import com.example.nesterenko.lab_1ml.ui.screens.BookListScreen
import java.util.Map.entry


private fun toggleBookRead(
    books: List<Book>,
    bookId: Int
): List<Book> {
    return books.map { book ->
        if (book.id == bookId) {
            book.copy(
                isRead = !book.isRead
            )
        } else {
            book
        }
    }
}

private val initialBooks = listOf(
    Book(
        id = 1,
        title = "Clean Code",
        author = "Robert C. Martin",
        description = "A handbook of agile software craftsmanship.",
        isRead = true
    ),
    Book(
        id = 2,
        title = "Kotlin in Action",
        author = "Dmitry Jemerov, Svetlana Isakova",
        description = null,
        isRead = false
    ),
    Book(
        id = 3,
        title = "Refactoring",
        author = "Martin Fowler",
        description = "Improving the design of existing code.",
        isRead = false
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTrackerApp() {
    var books by remember {
        mutableStateOf(
            initialBooks
        )
    }

    val backStack =
        rememberNavBackStack(
            BookListRoute
        )


    NavDisplay(
        backStack = backStack,

        onBack = {
            backStack.removeLastOrNull()
        },

        entryProvider = entryProvider {
            entry<BookListRoute> {

                BookListScreen(
                    books = books,

                    onBookClick = { bookId ->
                        backStack.add(
                            BookDetailsRoute(
                                bookId = bookId
                            )
                        )
                    },

                    onAddBook = {
                        backStack.add(
                            AddBookRoute
                        )
                    }
                )
            }

            entry<AddBookRoute> {

                AddBookScreen(
                    onCancel = {
                        backStack.removeLastOrNull()
                    },

                    onAddBook = {
                            title,
                            author,
                            description,
                            isRead ->

                        val nextId =
                            (books.maxOfOrNull {
                                it.id
                            } ?: 0) + 1

                        books = books + Book(
                            id = nextId,
                            title = title,
                            author = author,
                            description = description,
                            isRead = isRead
                        )

                        backStack.removeLastOrNull()
                    }
                )
            }

            entry<BookDetailsRoute> { route ->

                val book = books.find {
                    it.id == route.bookId
                }

                BookDetailsScreen(
                    book = book,

                    onBack = {
                        backStack.removeLastOrNull()
                    },

                    onToggleRead = {
                        books = toggleBookRead(
                            books = books,
                            bookId = route.bookId
                        )
                    }
                )
            }



        }
    )

}