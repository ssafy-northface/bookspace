package com.bookspace.mvc.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Wish {
	private Long wishId;    
    private Long userId;     
    private Long bookId;    
    private LocalDateTime wishDate; 
    private LocalDateTime deletedAt; 
}
