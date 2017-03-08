package com.devbarboza.hibernate.dao;

import com.devbarboza.hibernate.model.Book;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BookDaoImpl implements BookDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public BookDaoImpl() {
    }
    //session management//////////////////////////////////////////////////////
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    ///////////////////////////////////////////////////////////////////////////
    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Book book) {
        getCurrentSession().save(book);
    }

    public void update(Book book) {
        getCurrentSession().update(book);
    }

    public Book findById(String id) {
        Book book = (Book) getCurrentSession().get(Book.class, id);
        return book;
    }

    public void delete(Book book) {
        getCurrentSession().delete(book);
    }

    public List<Book> findAll() {
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
        return books;
    }

    public void deleteAll() {
        List<Book> bookList = findAll();
        for (Book book : bookList) {
            delete(book);
        }
    }
}
