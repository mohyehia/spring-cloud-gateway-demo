package com.moh.yehia.book.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

}


record Book(String title) {
}

@RestController
@Log4j2
class BookController {
    @GetMapping("/books")
    public List<Book> findBooks() {
        log.info("BookController :: findBooks :: Returning list of books");
        return List.of(new Book("His Dark Materials"),
                new Book("The Hobbit"),
                new Book("The Lord of the Rings"),
                new Book("The Fellowship of the Ring"));
    }
}