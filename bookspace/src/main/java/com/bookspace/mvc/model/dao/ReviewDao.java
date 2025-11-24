package com.bookspace.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookspace.mvc.model.dto.Review;

@Mapper
public interface ReviewDao {

	// 리뷰를 작성
	int insertReview(Review review);
	
	// 리뷰를 조회 (bookId 기준)
	List<Review> selectReviewByBookId(long bookId);
	
	// 리뷰를 수정
	int updateReview(Review review);
	
	// 리뷰를 삭제 (soft delete)
	int deleteReview(long reviewId);
	
	
}
