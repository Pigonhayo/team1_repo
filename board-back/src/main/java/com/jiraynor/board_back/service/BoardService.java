package com.jiraynor.board_back.service;

import org.springframework.http.ResponseEntity;
import com.jiraynor.board_back.dto.request.board.PostBoardRequestDto;
import com.jiraynor.board_back.dto.response.board.GetBoardResponseDto;
import com.jiraynor.board_back.dto.response.board.PostBoardResponseDto;
import com.jiraynor.board_back.dto.response.board.PutFavoriteResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);

    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);

    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

    // 보드 존재 여부를 확인하는 메서드 추가
    boolean boardExists(Integer boardNumber);
}