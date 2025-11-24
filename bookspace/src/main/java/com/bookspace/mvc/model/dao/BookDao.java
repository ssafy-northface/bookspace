package com.bookspace.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookspace.mvc.model.dto.Book;



@Mapper
public interface BookDao {

    /**
     * C: 책 등록  
     *
     * @param book 등록할 책 정보
     * @return INSERT된 행 수 (성공 시 1)
     */
    int insertBook(Book book);

    /**
     * R: 전체 책 목록을 조회
     *
     * @return 책 목록
     */
    List<Book> selectAllBooks();

    /**
     * 책 ID로 단일 책 정보 조회
     *
     * @param bookId 조회할 책의 ID
     * @return 조회된 책 정보 (없으면 null)
     */
    Book selectBookById(int bookId);

    /**
     * 유저의 감정 기반으로 추천할 책 목록을 조회
     *
     * @param emotion 사용자의 현재 감정 정보
     * @return 추천 책 목록
     */
    List<Book> selectBooksByEmotion(String emotion);

    /**
     * U: 책 정보 수정 
     *
     * @param book 수정할 책 정보
     * @return UPDATE된 행 수 (성공 시 1)
     */
    int updateBook(Book book);

    /**
     * D: 책 삭제 
     *
     * @param bookId 삭제할 책의 ID
     * @return DELETE된 행 수 (성공 시 1)
     */
    int deleteBook(int bookId);
}
