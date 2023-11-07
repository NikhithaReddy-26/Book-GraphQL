package com.pairprogramming.demo.controller;

import com.pairprogramming.demo.dto.BookDTO;
import com.pairprogramming.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

//    @GetMapping// for all

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Integer id){
        try{
            BookDTO bookDTO =bookService.getBookById(id);
            return  ResponseEntity.ok(bookDTO);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
@GetMapping
public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
}
    @PostMapping
    public  ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO){
        String addBookInfo = bookService.addBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addBookInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExistingBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO){
        String addBooKInfo = bookService.updateBook(id,bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addBooKInfo);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return "deleted successfully"+id;
    }
}
