package com.bookspace.mvc.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
	private Long bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublisher;
	private LocalDate bookPublicationDate;
	private String bookIsbn;
	private String bookDescription;
	private Integer bookPrice;
	private String bookImageUrl;
	private Integer bookSalesPoint;
	private String bookCategory;
}
