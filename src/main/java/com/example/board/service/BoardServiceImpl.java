package com.example.board.service;

import com.example.board.dto.request.InsertBoardRequestDto;
import com.example.board.dto.request.UpdateBoardRequestDto;
import com.example.board.dto.response.BoardOneResponseDto;
import com.example.board.exception.*;
import com.example.board.global.domain.entity.Board;
import com.example.board.global.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    public void save(InsertBoardRequestDto req) {
        boardRepository.save(req.toEntity());
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public List<Board> getBoardsByMemberId(Long memberId) {
        if(!boardRepository.existsByMemberId(memberId)) throw new UserNotFoundException();
        return boardRepository.findByMemberId(memberId);
    }

    public List<Board> getBoardsBySubGroupId(Long subGroupId) {
        if(!boardRepository.existsBySubGroupId(subGroupId)) throw new SubGroupNotFoundException();
        return boardRepository.findBySubGroupId(subGroupId);
    }

    public List<Board> getBoardsByCafeId(Long cafeId) {
        if(!boardRepository.existsByCafeId(cafeId)) throw new CafeNotFoundException();
        return boardRepository.findByCafeId(cafeId);
    }

    public List<Board> getBoardsByBoardTitle(String boardTitle) {
        if(!boardRepository.existsByBoardTitle(boardTitle)) throw new BoardTitleNotFoundException();
        return boardRepository.findByBoardTitle(boardTitle);
    }

    public void updateBoard(Long id, UpdateBoardRequestDto req) {
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isEmpty()) throw new BoardNotFoundException();
        Board board = byId.get();
        board.setBoardTitle(req.boardTitle());
        board.setBoardContent(req.boardContent());
        boardRepository.save(board);
    }


    public void deleteBoard(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isEmpty()) throw new BoardNotFoundException();
        boardRepository.deleteById(id);
    }

    public BoardOneResponseDto getBoardById(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isEmpty()) throw new BoardNotFoundException();
        Board board = byId.get();
        board.setBoardViews(board.getBoardViews()+1);
        boardRepository.save(board);
        return new BoardOneResponseDto(board);
    }
}
