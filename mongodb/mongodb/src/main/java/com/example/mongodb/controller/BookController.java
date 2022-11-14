package com.example.mongodb.controller;

import com.example.mongodb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mongodb.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        bookRepository.save(book);
        return "add book id : "+book.getId();
    }
    @GetMapping("/findAllBook")
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    @GetMapping("/findBook/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return bookRepository.findById(id);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
        return "book deleted with id : "+id;
    }

}
