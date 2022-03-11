package uk.sky.bookapi.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.sky.bookapi.models.Book;
import uk.sky.bookapi.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book = new Book("1", "Test title", "Test author", 9, "2021");
    private List<Book> books = new ArrayList<>();

    @BeforeAll
    public void beforeAll() {
        books.add(book);
    }

    @Test
    public void whenGetBooksCalled_returnBooks() {
        //when
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> retrievedBooks = bookService.getBooks();

        //then
        assertEquals(books, retrievedBooks);
        assertThat(books.get(0)).isEqualTo(retrievedBooks.get(0));
    }


}
