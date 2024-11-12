package com.jiraynor.board_back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.jiraynor.board_back.dto.request.board.PostBoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board")
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int boardNumber; // 레시피 게시판에는 필요하지 않지만 자유게시판에는 존재
    private String title;
    private String content;
    private String writeDatetime;
    private String writerEmail;
    private int favoriteCount;
    private int commentCount;
    private int price;

    public BoardEntity(PostBoardRequestDto dto, String email) {

        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.writeDatetime = writeDatetime;
        this.favoriteCount = 0;
        this.commentCount = 0;
        this.writerEmail = email;
    }

    // 평점 카운트 1 증가
    public void increaseFavoriteCount() {
        this.favoriteCount++;
    }

    // 평점 카운트 1 감소
    public void decreaseFavoriteCount() {
        this.favoriteCount--;
    }
}
