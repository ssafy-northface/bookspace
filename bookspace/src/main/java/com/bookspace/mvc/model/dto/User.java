package com.bookspace.mvc.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private Long userId; // PK
	private String userLoginId;
	private String userName;
	private String userNickname;
	private String userPw;
	private LocalDate userBirthDate;
	private String userPhone;
	private String userEmail;
	private LocalDateTime userRegistDate;
	private LocalDateTime deletedAt;
}
