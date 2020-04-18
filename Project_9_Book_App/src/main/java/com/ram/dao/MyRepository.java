package com.ram.dao;

import java.io.Serializable;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ram.entity.BookDetailsEntity;
import com.ram.model.BookDetails;

@Repository
@Transactional
public interface MyRepository
		extends JpaRepository<BookDetailsEntity, Serializable>, JpaSpecificationExecutor<BookDetails> {

	public List<BookDetailsEntity> findByActiveSwitch(String activeSwitch);

	@Modifying
	@Query(value = "UPDATE BookDetailsEntity set activeSwitch=:activeSwitch where bookId=:bookId")
	public void updateByBookIdNative(String activeSwitch, Integer bookId);

}
