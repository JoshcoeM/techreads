package com.manifestcorp.techreads.controller;

import com.manifestcorp.techreads.model.Book;
import com.manifestcorp.techreads.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class APIController  {
    @Autowired
    BookRepository bookRepository;

    @GetMapping({"","/"})
    public List<Book> books(){
        List<Book> books= bookRepository.findAll();
        return books;
    }

    @PostMapping("/add")
    public ResponseEntity<List<Book>> add(){
        Book book = new Book();
        bookRepository.saveAndFlush(book);
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Book> details(@PathVariable("id") String id){
        Optional<Book> book = Optional.of(bookRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return book;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@PathVariable("id") String id, @RequestBody Book book){
        bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Book>> delete(@PathVariable(value = "id") String id){
        bookRepository.deleteById(Long.valueOf(id));
        List<Book> books= bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
