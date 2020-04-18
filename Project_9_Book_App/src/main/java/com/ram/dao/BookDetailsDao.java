package com.ram.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.entity.BookDetailsEntity;
import com.ram.model.BookDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
@Data
public class BookDetailsDao {

	@Autowired
	private MyRepository myRepository;

	public boolean saveBookDetails(BookDetails bookDetails) {
		BookDetailsEntity bookEntity = new BookDetailsEntity();
		BeanUtils.copyProperties(bookDetails, bookEntity);
		bookEntity.setActiveSwitch("Y");
		BookDetailsEntity bookDetailsEntity = myRepository.save(bookEntity);
		return bookDetailsEntity != null;
	}

	public List<BookDetails> saveAllBook() {
		List<BookDetailsEntity> findAll = myRepository.findByActiveSwitch("Y");
		List<BookDetails> bookDtls = new ArrayList<>();
		for (BookDetailsEntity enti : findAll) {
			BookDetails bd = new BookDetails();
			BeanUtils.copyProperties(enti, bd);
			bookDtls.add(bd);
		}
		return bookDtls;
	}

	public BookDetails findByBookId(Integer bookId) {
		BookDetailsEntity en = null;
		Optional<BookDetailsEntity> findById = myRepository.findById(bookId);
		if (findById.isPresent()) {
			en = findById.get();
		}
		BookDetails bd = new BookDetails();
		BeanUtils.copyProperties(en, bd);
		return bd;
	}
	

	public boolean updateBookDetails(BookDetails books) {
		BookDetailsEntity en = new BookDetailsEntity();
		BeanUtils.copyProperties(books, en);
		BookDetailsEntity save = myRepository.save(en);
		return save != null;
	}

	public boolean updateBook(Integer bookId) {
		myRepository.updateByBookIdNative("N", bookId);
		return true;
	}

}
