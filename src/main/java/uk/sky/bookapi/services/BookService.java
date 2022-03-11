package uk.sky.bookapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.sky.bookapi.models.Book;
import uk.sky.bookapi.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Optional<Book> getBook(String id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        Optional<Book> existingBook = bookRepository.findById(book.getId());
        existingBook.get().setTitle(book.getTitle());
        existingBook.get().setAuthor(book.getAuthor());
        existingBook.get().setRating(book.getRating());
        existingBook.get().setReleaseDate(book.getReleaseDate());
        return bookRepository.save(existingBook.get());
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> findByTitle(String id) {
        return bookRepository.findById(id);
    }
}
