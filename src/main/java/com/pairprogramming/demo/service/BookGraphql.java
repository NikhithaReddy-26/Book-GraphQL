package com.pairprogramming.demo.service;


import com.pairprogramming.demo.dto.BookDTO;

import com.pairprogramming.demo.entity.Book;
import com.pairprogramming.demo.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookGraphql{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    public BookDTO getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return convertEntityToDTO(book);
    }

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = bookRepository.save(convertDTOToEntity(bookDTO));
        return convertEntityToDTO(book);
    }

    public BookDTO updateBook(Integer id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setBookName(bookDTO.getBookName());
        book.setAuthorName(bookDTO.getAuthorName());
        book.setAuthorId(bookDTO.getAuthorId());
        book = bookRepository.save(book);
        return convertEntityToDTO(book);
    }

    public String deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return "deleted ${id}";
    }

    private BookDTO convertEntityToDTO(Book book) {
        // Conversion logic
        return modelMapper.map(book, BookDTO.class);
    }

    private Book convertDTOToEntity(BookDTO bookDTO) {
        // Conversion logic
        return modelMapper.map(bookDTO, Book.class);
    }
}

