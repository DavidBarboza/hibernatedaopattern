package com.devbarboza.hibernate.dao;

import com.devbarboza.hibernate.model.Book;
import java.util.List;

public interface BookDao {
    	public void persist(Book book);
	
	public void update(Book book);
	
	public Book findById(String id);
	
	public void delete(Book book);
	
	public List<Book> findAll();
	
	public void deleteAll();
}
