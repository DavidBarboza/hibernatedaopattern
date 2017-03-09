package com.devbarboza.hibernate;

import com.devbarboza.hibernate.model.Book;
import com.devbarboza.hibernate.service.BookService;
import java.util.List;

public class App {

    public static void main(String[] args) {
        
        BookService bookService = new BookService();
        
        //create books
        Book book1 = new Book("1", "Algebra de Baldor", "Baldor");
        Book book2 = new Book("2", "Algebra de Benji", "Benji");
        Book book3 = new Book("3", "Algebra de Lili", "Lili");
        
        //save books to database
        System.out.println("*** Persist - start ***");
        bookService.persist(book1);
        bookService.persist(book2);
        bookService.persist(book3);
        
        //list books
        List<Book> books1 = bookService.findAll();
        System.out.println("Books Persisted are :");
        for (Book b : books1) {
            System.out.println("-" + b.toString());
        }

        System.exit(0);

    }
}
