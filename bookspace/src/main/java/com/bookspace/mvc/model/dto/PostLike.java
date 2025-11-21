package com.bookspace.mvc.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostLike {
	private long likeId;
	private long postId;
	private long userId;
	private LocalDateTime likeDate;
	private LocalDateTime deletedAt;
}
