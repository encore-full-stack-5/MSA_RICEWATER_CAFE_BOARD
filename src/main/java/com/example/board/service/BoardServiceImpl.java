package com.example.board.service;

import com.example.board.dto.request.InsertBoardRequestDto;
import com.example.board.dto.request.UpdateBoardRequestDto;
import com.example.board.global.domain.entity.Board;
import com.example.board.global.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void save(InsertBoardRequestDto req) {
        boardRepository.save(req.toEntity());
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public List<Board> getBoardsByMemberId(Long memberId) {
        return boardRepository.findByMemberId(memberId);
    }

    public List<Board> getBoardsBySubGroupId(Long subGroupId) {
        return boardRepository.findBySubGroupId(subGroupId);
    }

    public List<Board> getBoardsByCafeId(Long cafeId) {
        return boardRepository.findByCafeId(cafeId);
    }

    public List<Board> getBoardsByBoardTitle(String boardTitle) {
        return boardRepository.findByBoardTitle(boardTitle);
    }

    public void updateBoard(Long id, UpdateBoardRequestDto req) {
        Optional<Board> byId = boardRepository.findById(id);
        Board board = byId.orElseThrow(() -> new IllegalArgumentException("없는 board"));
        board.setBoardTitle(req.boardTitle());
        board.setBoardContent(req.boardContent());
        boardRepository.save(board);
    }


    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no exist board"));
    }
}
