package com.jiraynor.board_back.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jiraynor.board_back.common.ResponseCode;
import com.jiraynor.board_back.common.ResponseMessage;
import com.jiraynor.board_back.dto.response.ResponseDto;
import com.jiraynor.board_back.entity.ImageEntity;
import com.jiraynor.board_back.repository.resultSet.GetBoardResultSet;

import lombok.Getter;

@Getter
public class GetBoardResponseDto extends ResponseDto {

  private int boardNumber;
  private String title;
  private String content;
  private List<String> boardImageList;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;
  private int price;
  private double averageRating; // 평균 평점 추가

  private GetBoardResponseDto(GetBoardResultSet resultSet, List<ImageEntity> imageEntities, double averageRating) {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

    List<String> boardImageList = new ArrayList<>();
    for (ImageEntity imageEntity : imageEntities) {
      String boardImage = imageEntity.getImage();
      boardImageList.add(boardImage);
    }

    this.boardNumber = resultSet.getBoardNumber();
    this.title = resultSet.getTitle();
    this.content = resultSet.getContent();
    this.boardImageList = boardImageList;
    this.writeDatetime = resultSet.getWriteDateTime();
    this.writerEmail = resultSet.getWriterEmail();
    this.writerNickname = resultSet.getWriterNickname();
    this.price = resultSet.getPrice();
    this.averageRating = averageRating; // 평균 평점 설정
  }

  public static ResponseEntity<GetBoardResponseDto> success(GetBoardResultSet resultSet,
      List<ImageEntity> imageEntities, double averageRating) {
    GetBoardResponseDto result = new GetBoardResponseDto(resultSet, imageEntities, averageRating);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistBoard() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}