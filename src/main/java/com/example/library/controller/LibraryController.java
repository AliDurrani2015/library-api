package com.example.library.controller;

import com.example.library.model.*;
import com.example.library.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/borrowers")
    public Borrower registerBorrower(@Valid @RequestBody Borrower borrower) {
        return libraryService.addBorrower(borrower);
    }

    @PostMapping("/books")
    public Book registerBook(@Valid @RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> listBooks() {
        return libraryService.getAllBooks();
    }

    @PostMapping("/borrow/{borrowerId}/book/{bookId}")
    public String borrowBook(@PathVariable Long borrowerId, @PathVariable Long bookId) {
        return libraryService.borrowBook(borrowerId, bookId);
    }

    @PostMapping("/return/book/{bookId}")
    public String returnBook(@PathVariable Long bookId) {
        return libraryService.returnBook(bookId);
    }
}
