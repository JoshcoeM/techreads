package com.manifestcorp.techreads;

import com.manifestcorp.techreads.model.Book;
import com.manifestcorp.techreads.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    protected BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        if(bookRepository.count()<3){
            bookRepository.save(new Book("Beginning Groovy and Grails", "https://i.imgur.com/kR54Nsy.jpg", "Chris Judd","3/5"));
            bookRepository.save(new Book("Pro Eclipse JST","https://images-na.ssl-images-amazon.com/images/I/41-LWysZdeL._SX258_BO1,204,203,200_.jpg","Christopher Judd","2/5"));
            bookRepository.save(new Book("Enterprise Java Development on a Budget","https://images-na.ssl-images-amazon.com/images/I/51H3bPvfkEL._SX404_BO1,204,203,200_.jpg ","Christopher M Judd","4/5"));
        }
    }
}
