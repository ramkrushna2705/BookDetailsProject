package com.ram.service;

import java.util.List;

import com.ram.model.BookDetails;

public interface BookDetailsService {

	public boolean saveBook(BookDetails book);

	public List<BookDetails> getAllActive();
	
	public BookDetails getBookById(Integer bookId);
	
	public boolean updateBook(BookDetails books);
	
	public boolean deleteBook(Integer bookId);

}
