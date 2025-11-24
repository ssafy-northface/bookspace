package com.bookspace.mvc.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bookspace.mvc.model.dto.PostLike;

@Mapper
public interface PostLikeDao {
	
	// 게시글에 좋아요 남기기
	int insertLike(PostLike like);
	
	// 남긴 좋아요 삭제
	int deleteLike(long likeId);
	
	// 좋아요 개수 카운트 (postId 기준)
	int countLikeByPostId(long postId);
	
	// 이미 좋아요를 눌렀는지 확인
	// int로 반환해도 OK
	boolean existLike(@Param("postId") long postId, @Param("userId") long userId);
	
	
}
