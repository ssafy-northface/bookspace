package com.bookspace.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookspace.mvc.model.dto.Post;

@Mapper
public interface PostDao {

    /**
     * C: 새로운 책 게시물을 등록
     *
     * @param post 등록할 게시물 정보
     * @return INSERT된 행 수 (성공 시 1)
     */
    int insertPost(Post post);

    /**
     * R: 전체 책 게시물 목록을 조회 
     *
     * @return 게시물 목록
     */
    List<Post> selectAllPosts();

    /**
     * 게시물 ID로 단일 책 게시물을 조회 
     *
     * @param postId 조회할 게시물 ID
     * @return 게시물 정보 (없으면 null)
     */
    Post selectPostById(int postId);

    /**
     * 특정 책에 대한 모든 게시물 목록을 조회 
     *
     * @param bookId 대상 책 ID
     * @return 게시물 목록
     */
    List<Post> selectPostsByBookId(int bookId);

    /**
     * 특정 사용자가 작성한 게시물 목록을 조회 
     *
     * @param userId 작성자 ID
     * @return 게시물 목록
     */
    List<Post> selectPostsByUser(int userId);

    /**
     * U: 게시물 내용을 수정 
     *
     * @param post 수정된 게시물 정보
     * @return UPDATE된 행 수 (성공 시 1)
     */
    int updatePost(Post post);

    /**
     * 게시물의 조회수를 증가 
     *
     * @param postId 조회수를 증가시킬 게시물 ID
     * @return UPDATE된 행 수 (성공 시 1)
     */
    int updateViewCount(int postId);

    /**
     * D: 게시물을 삭제 
     *
     * @param postId 삭제할 게시물 ID
     * @return DELETE된 행 수 (성공 시 1)
     */
    int deletePost(int postId);
}
