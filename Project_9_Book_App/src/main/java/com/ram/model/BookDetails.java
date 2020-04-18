package com.ram.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BookDetails {

	private Integer bookId;
	private String bookName;
	private double bookPrice;
	private String authorName;
	private String activeSwitch;
	
}
