package com.pairprogramming.demo.service;

import com.pairprogramming.demo.dto.BookDTO;
import com.pairprogramming.demo.entity.Book;
import com.pairprogramming.demo.exception.BookNotFoundException;
import com.pairprogramming.demo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository=bookRepository;

    }

    @Override
    public BookDTO getBookById(Integer id) {
        Optional<Book> bookInfo = bookRepository.findById(id);
        return bookInfo.map(this::entityTODto).orElseThrow(()->new BookNotFoundException("book not found with the id :"+id));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().map(this::entityTODto).toList();
//        log.info("fetching all the books");
    }

    @Override
    public String addBook(BookDTO bookDTO) {
        Book addBook = dtoToEntity(bookDTO);
        bookRepository.save(addBook);
        return "book added successfully";
    }

    @Override
    public String deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return "deleted successfully"+id;
    }

    @Override
    public String updateBook(Integer id, BookDTO bookDTO) {
        Book updateExistingBook = bookRepository.findById(id).orElseThrow(()->new NoSuchElementException(("No book found")));
        updateExistingBook.setBookName(bookDTO.getBookName());
        updateExistingBook.setAuthorId(bookDTO.getAuthorId());
        updateExistingBook.setAuthorName(bookDTO.getAuthorName());
        bookRepository.save(updateExistingBook);
        return "updated the details of id "+id;
    }
    public BookDTO entityTODto (Book book){
        return modelMapper.map(book, BookDTO.class);
    }
    public Book dtoToEntity(BookDTO bookDTO){
        return modelMapper.map(bookDTO, Book.class);
    }
}
