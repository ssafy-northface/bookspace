package com.bookspace.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bookspace.mvc.model.dto.Wish;

@Mapper
public interface WishDao {

	// 찜하기
	int insertWish(Wish wish);
	
	// 찜 취소
	int deleteWish(long wishId);
	
	// 찜 조회 (userId 기준)
	List<Wish> selectByUserId(long userId);
	
	// 이미 찜을 했는지 확인
	boolean existWish(@Param("bookId") long bookId, @Param("userId") long userId);
	
}
