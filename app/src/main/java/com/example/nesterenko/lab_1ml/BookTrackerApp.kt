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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
import com.example.nesterenko.lab_1ml.ui.BookViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTrackerApp() {

    val bookViewModel: BookViewModel = viewModel(factory = BookViewModel.Factory)

    val uiState by bookViewModel.uiState.collectAsStateWithLifecycle()

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
                    books = uiState.books,

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

                        bookViewModel.addBook(
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

                val book = uiState.books.find {
                    it.id == route.bookId
                }

                BookDetailsScreen(
                    book = book,

                    onBack = {
                        backStack.removeLastOrNull()
                    },

                    onToggleRead = {
                       bookViewModel.toggleBookRead(route.bookId)
                    }
                )
            }



        }
    )

}