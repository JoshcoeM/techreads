package com.manifestcorp.techreads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manifestcorp.techreads.model.Book;
import com.manifestcorp.techreads.repository.BookRepository;
import org.springframework.web.servlet.view.RedirectView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping({"","/"})
    public ModelAndView books(){
        ModelAndView mav = new ModelAndView("books");
        List<Book> books= bookRepository.findAll();
        mav.addObject("books",books);
        return mav;
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("bookForm", new Book());
        return "add";
    }

    @RequestMapping(value ={"","/"}, method=POST)
    public RedirectView addBook(Book book){
        bookRepository.saveAndFlush(book);
        return new RedirectView("books");
    }

    @RequestMapping("/{id}")
    public ModelAndView details(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView("details");
        Book book = bookRepository.getById(id);
        mav.addObject("book",book);
        return mav;
    }
    
    @RequestMapping("edit/{id}")
    public String edit(Model model, @PathVariable(value = "id") Long id){
        Book book = bookRepository.getById(id);
        model.addAttribute("bookForm", book);
        return "add";
    }

    @RequestMapping("delete/{id}")
    public RedirectView delete(@PathVariable(value = "id") Long id){
        bookRepository.deleteById(id);
        return new RedirectView("/");
    }



}
