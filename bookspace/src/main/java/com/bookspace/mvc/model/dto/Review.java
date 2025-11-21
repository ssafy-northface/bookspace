package com.bookspace.mvc.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Review {
	private Long reviewId;
	private Long bookId;
	private Long userId;
	private Double reviewRating;
	private String reviewContent;
	private LocalDateTime reviewDate;
	private LocalDateTime reviewLastModified;
	private LocalDateTime deletedAt;
}
