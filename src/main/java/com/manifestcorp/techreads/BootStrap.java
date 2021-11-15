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
            bookRepository.save(new Book("Beginning Groovy and Grails", "tinyurl.com/wfj77skm", "Chris Judd","3/5"));
            bookRepository.save(new Book("Pro Eclipse JST","tinyurl.com/8bbe4633","Christopher Judd","2/5"));
            bookRepository.save(new Book("Enterprise Java Development on a Budget","tinyurl.com/3pf9za4w ","Christopher M Judd","4/5"));
        }
    }
}
