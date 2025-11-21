-- 데이터베이스 생성
DROP DATABASE IF EXISTS bookspace;
CREATE DATABASE IF NOT EXISTS bookspace;
USE bookspace;

-- user: 회원 (Soft Delete 대상: 회원 탈퇴)
CREATE TABLE `user` (
    `user_id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_login_id` VARCHAR(50) NOT NULL UNIQUE,
    `user_name` VARCHAR(50) NOT NULL,
    `user_nickname` VARCHAR(50) NULL UNIQUE,
    `user_pw` VARCHAR(255) NOT NULL,
    `user_birth_date` DATE NULL,
    `user_phone` VARCHAR(20) NULL,
    `user_email` VARCHAR(255) NOT NULL UNIQUE,
    `user_regist_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted_at` TIMESTAMP NULL DEFAULT NULL,
    CONSTRAINT `PK_USER` PRIMARY KEY (`user_id`)
);

-- book: 책 정보 (삭제 기능 없음)
CREATE TABLE `book` (
    `book_id` BIGINT NOT NULL AUTO_INCREMENT,
    `book_title` VARCHAR(255) NOT NULL,
    `book_author` VARCHAR(255) NOT NULL,
    `book_publisher` VARCHAR(100) NOT NULL,
    `book_publication_date` DATE NULL,
    `book_isbn` VARCHAR(20) NOT NULL UNIQUE,
    `book_description` TEXT NULL,
    `book_price` INT NOT NULL DEFAULT 0,
    `book_image_url` VARCHAR(500) NULL,
    `book_sales_point` INT NOT NULL DEFAULT 0,
    `book_category` VARCHAR(50) NOT NULL,
    CONSTRAINT `PK_BOOK` PRIMARY KEY (`book_id`)
);

-- review: 책 리뷰 (Soft Delete 대상)
CREATE TABLE `review` (
    `review_id` BIGINT NOT NULL AUTO_INCREMENT,
    `book_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `review_rating` DECIMAL(2,1) NOT NULL CHECK (review_rating >= 0.0 AND review_rating <= 5.0),
    `review_content` VARCHAR(300) NULL,
    `review_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `review_last_modified` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` TIMESTAMP NULL DEFAULT NULL,
    CONSTRAINT `PK_REVIEW` PRIMARY KEY (`review_id`)
);

-- wish: 찜 리스트 (Soft Delete 대상)
CREATE TABLE `wish` (
    `wish_id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    `book_id` BIGINT NOT NULL,
    `wish_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted_at` TIMESTAMP NULL DEFAULT NULL,
    CONSTRAINT `PK_WISH` PRIMARY KEY (`wish_id`),
    CONSTRAINT UK_WISH_USER_BOOK UNIQUE (`user_id`, `book_id`) -- [추가] 중복 찜 방지
);

-- post: 게시글 (Soft Delete 대상)
CREATE TABLE `post` (
    `post_id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    `book_id` BIGINT NOT NULL,
    `post_title` VARCHAR(255) NOT NULL,
    `post_content` TEXT NOT NULL,
    `post_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `post_view_cnt` INT NOT NULL DEFAULT 0,
    `post_last_modified` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` TIMESTAMP NULL DEFAULT NULL,
    CONSTRAINT `PK_POST` PRIMARY KEY (`post_id`)
);

-- comment: 게시글 댓글 (Soft Delete 대상)
CREATE TABLE `comment` (
    `comment_id` BIGINT NOT NULL AUTO_INCREMENT,
    `post_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `comment_content` VARCHAR(300) NOT NULL,
    `comment_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `comment_last_modified` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` TIMESTAMP NULL DEFAULT NULL,
    CONSTRAINT `PK_COMMENT` PRIMARY KEY (`comment_id`)
);

-- post_like: 게시글 좋아요 (Soft Delete 대상)
CREATE TABLE `post_like` (
    `like_id` BIGINT NOT NULL AUTO_INCREMENT,
    `post_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `like_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted_at` TIMESTAMP NULL DEFAULT NULL,
    CONSTRAINT `PK_POST_LIKE` PRIMARY KEY (`like_id`),
    CONSTRAINT UK_LIKE_USER_POST UNIQUE (`user_id`, `post_id`) -- [추가] 중복 좋아요 방지
);


-- ================================
--        FOREIGN KEY 설정
-- ================================

-- review FK
ALTER TABLE `review` ADD CONSTRAINT `FK_book_TO_review_1` FOREIGN KEY (`book_id`)
    REFERENCES `book` (`book_id`);

ALTER TABLE `review` ADD CONSTRAINT `FK_user_TO_review_1` FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`);

-- comment FK
ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (`post_id`)
    REFERENCES `post` (`post_id`);

ALTER TABLE `comment` ADD CONSTRAINT `FK_user_TO_comment_1` FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`);

-- post_like FK
ALTER TABLE `post_like` ADD CONSTRAINT `FK_post_TO_post_like_1` FOREIGN KEY (`post_id`)
    REFERENCES `post` (`post_id`);

ALTER TABLE `post_like` ADD CONSTRAINT `FK_user_TO_post_like_1` FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`);

-- wish FK
ALTER TABLE `wish` ADD CONSTRAINT `FK_user_TO_wish_1` FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`);

ALTER TABLE `wish` ADD CONSTRAINT `FK_book_TO_wish_1` FOREIGN KEY (`book_id`)
    REFERENCES `book` (`book_id`);

-- post FK
ALTER TABLE `post` ADD CONSTRAINT `FK_user_TO_post_1` FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`);

ALTER TABLE `post` ADD CONSTRAINT `FK_book_TO_post_1` FOREIGN KEY (`book_id`)
    REFERENCES `book` (`book_id`);