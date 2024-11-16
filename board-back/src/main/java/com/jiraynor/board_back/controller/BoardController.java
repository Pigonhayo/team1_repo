package com.jiraynor.board_back.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.jiraynor.board_back.dto.request.board.PostBoardRequestDto;
import com.jiraynor.board_back.dto.response.board.GetBoardResponseDto;
import com.jiraynor.board_back.dto.response.board.PostBoardResponseDto;
import com.jiraynor.board_back.entity.BoardEntity;
import com.jiraynor.board_back.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    // 메인 페이지에서 게시물 불러오기
    @GetMapping("/top-3")
    public ResponseEntity<List<BoardEntity>> getMainSiteBoards() {
        List<BoardEntity> randomBoards = boardService.getRandomBoards();
        return ResponseEntity.status(HttpStatus.OK).body(randomBoards);
    }

    // 레시피 게시판에서 불러오기
    @GetMapping("/lastest-list")
    public ResponseEntity<List<BoardEntity>> getRecipeSiteBoards() {
        List<BoardEntity> allBoards = boardService.getAllBoards();
        return ResponseEntity.status(HttpStatus.OK).body(allBoards);
    }

    // 게시물 상세 페이지 가지고 올 때
    // url에서 boardNumber를 가져와서 그 걸 메핑하는 작업이 필요한 것
    // 그래서 Post에서는 필요없는 매핑이 필요해!
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardNumber") Integer boardNumber) {

        // 보드 존재 여부 확인
        if (!boardService.boardExists(boardNumber)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Board not found");
        }

        // 보드가 존재하면 서비스에서 상세 정보 반환
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    // 레시피 작성 관련
    @PostMapping
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
            @RequestBody @Valid PostBoardRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }

    
}
