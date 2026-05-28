package org.example.bai1.service;

import org.example.bai1.exception.BookNotaFoundException;
import org.example.bai1.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long currentId = 1L;
    public List<Book> getAllBooks() {
        return books;
    }
    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotaFoundException("Sách ko tồn tại"));
    }
    public Book addBook(Book book) {
        book.setId(currentId++);
        books.add(book);
        return book;
    }
    public Book updateBook(Long id, Book updateBook){
        Book book = getBookById(id);
        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
        book.setPrice(updateBook.getPrice());
        return book;
    }
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        books.remove(book);
    }
}
