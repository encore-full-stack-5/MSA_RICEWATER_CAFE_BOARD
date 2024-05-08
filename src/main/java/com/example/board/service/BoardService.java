package com.example.board.service;

import com.example.board.dto.request.InsertBoardRequestDto;
import com.example.board.dto.request.UpdateBoardRequestDto;
import com.example.board.dto.response.BoardOneResponseDto;
import com.example.board.global.domain.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    public void save(InsertBoardRequestDto req);

    public List<Board> getAllBoards();

    public List<Board> getBoardsByMemberId(Long memberId);


    public List<Board> getBoardsBySubGroupId(Long subGroupId);

    public List<Board> getBoardsByCafeId(Long cafeId);

    public List<Board> getBoardsByBoardTitle(String boardTitle);

    public void updateBoard(Long id, UpdateBoardRequestDto req);


    public void deleteBoard(Long id);

    public BoardOneResponseDto getBoardById(Long id);
}
