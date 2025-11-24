package com.bookspace.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookspace.mvc.model.dto.User;

@Mapper
public interface UserDao {
	
	// 전체 회원 조회
	List<User> selectAllUsers();
	
	// 회원 한명 조회 (By userId)
	User selectUserById(long userId);
	
	// 회원가입
	int insertUser(User user);
	
	// 회원 정보 수정
	int updateUser(User user);
	
	// 회원 탈퇴 (soft delete)
	int deleteUser(long userId);
	
	// 로그인을 위해 loginId로 회원 조회
	User selectUserByLoginId(String userLoginId);
	
	// 이메일 중복 여부 확인
	// (회원가입 시 이메일 중복 작성 불가)
	boolean existUserByEmail(String email);
	
	
}
