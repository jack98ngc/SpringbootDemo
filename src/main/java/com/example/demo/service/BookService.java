/*
 * created on May 23, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 23, 2021 $
 */
package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    
    public Page<Book> findAllByPage(){
        
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(1, 5, sort);
        return bookRepository.findAll(pageable);
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
    
    public List<Book> findByJPQL(int len){
        return bookRepository.findByJPQL(len);
    }

    public List<Book> findBySQL(int len){
        return bookRepository.findBySQL(len);
    }
    
    @Transactional
    public int updateByJPQL(int status, long id) {
        return bookRepository.updateByJPQL(status, id);
    }

    @Transactional
    public int deleteByJPQL(long id) {
        return bookRepository.deleteByJPQL(id);
    }
    
    @Transactional
    public int deleteAndUpdate(long id, int status, long uid) {
        int dcount = bookRepository.deleteByJPQL(id);
        
        int ucount = bookRepository.updateByJPQL(status, uid);
        
        return dcount + ucount;
    }
}
