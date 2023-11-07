package com.pairprogramming.demo.service;

import com.pairprogramming.demo.dto.BookDTO;
import com.pairprogramming.demo.entity.Book;

import java.util.List;

public interface BookService {
    public BookDTO getBookById(Integer id);

    public List<BookDTO> getAllBooks();

    public String addBook(BookDTO bookDTO);

    public String deleteBook(Integer id);

    public String updateBook(Integer id, BookDTO bookDTO);


}
