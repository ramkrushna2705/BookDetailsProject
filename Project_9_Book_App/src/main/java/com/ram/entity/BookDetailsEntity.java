package com.ram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK_DETAILS")
public class BookDetailsEntity {

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue
	private Integer bookId;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "BOOK_PRICE")
	private Double bookPrice;
	@Column(name = "BOOK_AUTHOR")
	private String authorName;
	@Column(name = "ACTIVE_SWITCH")
	private String activeSwitch;

}
