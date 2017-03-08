package com.devbarboza.hibernate.service;

import com.devbarboza.hibernate.dao.BookDaoImpl;
import com.devbarboza.hibernate.model.Book;
import java.util.List;

public class BookService {

    private static BookDaoImpl bookDao;

    public BookService() {
        bookDao = new BookDaoImpl();
    }

    public void persist(Book book) {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.persist(book);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public void update(Book book) {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.update(book);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public Book findById(String id) {
        bookDao.openCurrentSession();
        Book book = bookDao.findById(id);
        bookDao.closeCurrentSession();
        return book;
    }

    public void delete(String id) {
        bookDao.openCurrentSessionWithTransaction();
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public List<Book> findAll() {
        bookDao.openCurrentSession();
        List<Book> books = bookDao.findAll();
        bookDao.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.deleteAll();
        bookDao.closeCurrentSessionWithTransaction();
    }
    
    public BookDaoImpl bookDao(){
        return bookDao;
    }
}
