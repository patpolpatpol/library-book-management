package com.example.library_book_management.service;

import com.example.library_book_management.model.Book;
import com.example.library_book_management.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllBooks_ShouldReturnAllBooks() {
        List<Book> books = Arrays.asList(
                new Book("Title 1", "Author 1", "ISBN1", LocalDate.now()),
                new Book("Title 2", "Author 2", "ISBN2", LocalDate.now())
        );
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.findAllBooks();

        assertEquals(2, result.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void findBookById_ShouldReturnBook() {
        Book book = new Book("Title 1", "Author 1", "ISBN1", LocalDate.now());
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.findBookById(1L);

        assertTrue(result.isPresent());
        assertEquals("Title 1", result.get().getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void addBook_ShouldAddBook() {
        Book book = new Book("Title 1", "Author 1", "ISBN1", LocalDate.now());
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.addBook(book);

        assertNotNull(result);
        assertEquals("Title 1", result.getTitle());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void updateBook_ShouldUpdateBook() {
        Book book = new Book("Title 1", "Author 1", "ISBN1", LocalDate.now());
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        Book bookDetails = new Book("Title Updated", "Author Updated", "ISBN1", LocalDate.now());
        Book result = bookService.updateBook(1L, bookDetails);

        assertNotNull(result);
        assertEquals("Title Updated", result.getTitle());
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void deleteBook_ShouldDeleteBook() {
        doNothing().when(bookRepository).deleteById(1L);

        bookService.deleteBook(1L);

        verify(bookRepository, times(1)).deleteById(1L);
    }
}
