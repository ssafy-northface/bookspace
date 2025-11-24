package com.bookspace.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookspace.mvc.model.dto.Comment;


@Mapper
public interface CommentDao {

    /**
     * C: 새로운 댓글을 등록 
     *
     * @param comment 등록할 댓글 정보
     * @return INSERT된 행 수 (성공 시 1)
     */
    int insertComment(Comment comment);

    /**
     * R: 특정 게시물에 달린 전체 댓글 목록을 조회 
     *
     * @param postId 댓글을 조회할 게시물 ID
     * @return 댓글 목록
     */
    List<Comment> selectCommentsByPostId(int postId);

    /**
     * 특정 댓글 ID로 단일 댓글을 조회 
     *
     * @param commentId 댓글 ID
     * @return 댓글 정보 (없으면 null)
     */
    Comment selectCommentById(int commentId);

    /**
     * 특정 사용자가 작성한 댓글 목록을 조회 
     *
     * @param userId 작성자 ID
     * @return 댓글 목록
     */
    List<Comment> selectCommentsByUserId(int userId);

    /**
     * U: 댓글 내용을 수정 
     *
     * @param comment 수정된 댓글 정보
     * @return UPDATE된 행 수 (성공 시 1)
     */
    int updateComment(Comment comment);

    /**
     * D: 댓글을 삭제 
     *
     * @param commentId 삭제할 댓글 ID
     * @return DELETE된 행 수 (성공 시 1)
     */
    int deleteComment(int commentId);
}
