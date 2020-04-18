package com.ram.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.dao.BookDetailsDao;
import com.ram.model.BookDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@Data
public class BookDetailsServiceImpl implements BookDetailsService {

	@Autowired
	private BookDetailsDao bookDetailsDao;

	@Override
	public boolean saveBook(BookDetails book) {
		boolean saveBookDetails = bookDetailsDao.saveBookDetails(book);
		return saveBookDetails ? true : false;
	}

	@Override
	public List<BookDetails> getAllActive() {
		List<BookDetails> saveAllBook = bookDetailsDao.saveAllBook();
		return saveAllBook;
	}

	@Override
	public boolean deleteBook(Integer bookId) {
		boolean updateBook = bookDetailsDao.updateBook(bookId);
		return updateBook ? true : false;
	}

	@Override
	public BookDetails getBookById(Integer bookId) {
		BookDetails findByBookId = bookDetailsDao.findByBookId(bookId);
		return findByBookId;
	}

	@Override
	public boolean updateBook(BookDetails books) {
		boolean updateBookDetails = bookDetailsDao.updateBookDetails(books);
		return updateBookDetails ? true : false;
	}

}
