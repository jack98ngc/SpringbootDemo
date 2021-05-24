/*
 * created on May 23, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 23, 2021 $
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findOne(Long id) {
        Book one = bookRepository.getOne(id);
        return one;
    }

    public void deleteOne(long id) {
        bookRepository.delete(id);
    }
    
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    public List<Book> findByDescriptionEndsWith(String desc) {
        return bookRepository.findByDescriptionEndsWith(desc);
    }

    public List<Book> findByDescriptionContains(String desc) {
        return bookRepository.findByDescriptionContains(desc);
    }
    
}
