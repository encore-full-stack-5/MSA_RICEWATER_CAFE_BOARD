package com.example.board.dto.response;

import com.example.board.global.domain.entity.Board;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class BoardOneResponseDto {
    Long id;
    String boardTitle;
    String boardContent;
    Long boardViews;
    LocalDateTime createdAt;
    Long cafeId;
    Long subGroupId;

    public BoardOneResponseDto(Board board) {
        this.id = board.getId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.boardViews = board.getBoardViews();
        this.createdAt = board.getCreatedAt();
        this.cafeId = board.getCafeId();
        this.subGroupId = board.getSubGroupId();
    }
}
