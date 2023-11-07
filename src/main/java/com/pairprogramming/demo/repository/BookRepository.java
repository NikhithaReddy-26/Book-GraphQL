package com.pairprogramming.demo.repository;

import com.pairprogramming.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
