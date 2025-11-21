package com.bookspace.mvc.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Post {
	private long postId;
	private long userId;
	private long bookId;
	private String postTitle;
	private String postContent;
	private LocalDateTime postDate;
	private int postViewCnt;
	private LocalDateTime postLastModified;
	private LocalDateTime deletedAt;
}
