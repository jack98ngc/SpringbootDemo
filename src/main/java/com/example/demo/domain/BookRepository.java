/*
 * created on May 23, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 23, 2021 $
 */
package com.example.demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Long>{

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, int status);

    List<Book> findByDescriptionEndsWith(String desc);

    List<Book> findByDescriptionContains(String desc);
    
    @Query("select b from Book b where length(b.name) > ?1")
    List<Book> findByJPQL(int len);

    @Query(value="select * from book b where length(b.name) > ?1", nativeQuery=true)
    List<Book> findBySQL(int len);
}
