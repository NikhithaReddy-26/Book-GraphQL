package com.pairprogramming.demo.resolver;

import com.pairprogramming.demo.dto.BookDTO;
import com.pairprogramming.demo.service.BookGraphql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookGraphQLController {

    @Autowired
    private BookGraphql bookGraphql;

    @QueryMapping
    public BookDTO getBook(@Argument Integer id) {
        return bookGraphql.getBookById(id);
    }

    @QueryMapping
    public List<BookDTO> allBooks() {
        return bookGraphql.getAllBooks();
    }

    @MutationMapping
    public BookDTO createBook(@Argument("input") BookDTO input) {
        return bookGraphql.addBook(input);
    }


    @MutationMapping
    public BookDTO updateBook(@Argument Integer id, @Argument BookDTO input) {
        return bookGraphql.updateBook(id, input);
    }

    @MutationMapping
    public String deleteBook(@Argument Integer id) {
        return bookGraphql.deleteBook(id);
    }
}
