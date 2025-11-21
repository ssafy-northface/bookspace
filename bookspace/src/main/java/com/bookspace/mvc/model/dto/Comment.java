package com.bookspace.mvc.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Comment {
	private long commentId;
	private long postId;
	private long userId;
	private String commentContent;
	private LocalDateTime commentDate;
	private LocalDateTime commentLastModified;
	private LocalDateTime deletedAt;
}
