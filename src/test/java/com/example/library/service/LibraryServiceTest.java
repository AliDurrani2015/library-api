package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Borrower;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LibraryServiceTest {

    @InjectMocks
    private LibraryService libraryService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BorrowerRepository borrowerRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBorrowBook_Success() {
        Book book = new Book(1L, "111", "Title", "Author", false);
        Borrower borrower = new Borrower(1L, "Ali", "ali@example.com");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(borrowerRepository.findById(1L)).thenReturn(Optional.of(borrower));

        String result = libraryService.borrowBook(1L, 1L);

        assertEquals("Book borrowed successfully", result);
        assertTrue(book.isBorrowed());
        verify(bookRepository).save(book);
    }

    @Test
    void testBorrowBook_AlreadyBorrowed() {
        Book book = new Book(1L, "111", "Title", "Author", true);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            libraryService.borrowBook(1L, 1L);
        });

        assertEquals("Book already borrowed", exception.getMessage());
    }
}
