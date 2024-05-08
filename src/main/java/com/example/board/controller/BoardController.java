package com.example.board.controller;

import com.example.board.dto.request.InsertBoardRequestDto;
import com.example.board.dto.request.UpdateBoardRequestDto;
import com.example.board.dto.response.BoardOneResponseDto;
import com.example.board.global.domain.entity.Board;
import com.example.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImpl boardService;

    @PostMapping
    public void insertBoard(
            @RequestBody InsertBoardRequestDto req
    ){
        boardService.save(req);
    }

    @GetMapping
    public List<Board> getAllBoards(@RequestParam(name = "memberId", required = false, defaultValue = "-1") Long memberId,
                                    @RequestParam(name = "subGroupId",required = false, defaultValue = "-1") Long subGroupId,
                                    @RequestParam(name = "cafeId",required = false, defaultValue = "-1") Long cafeId,
                                    @RequestParam(name = "boardTitle",required = false, defaultValue = "" ) String boardTitle
                                    ){
        if(memberId != -1) return boardService.getBoardsByMemberId(memberId);
        else if(subGroupId != -1) return boardService.getBoardsBySubGroupId(subGroupId);
        else if(cafeId != -1) return boardService.getBoardsByCafeId(cafeId);
        else if(boardTitle != null && !boardTitle.isEmpty()) return boardService.getBoardsByBoardTitle(boardTitle);
        else return boardService.getAllBoards();
    }

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable("id") Long id, @RequestBody UpdateBoardRequestDto req
    ){
        boardService.updateBoard(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
    }

    @GetMapping("/{id}")
    public BoardOneResponseDto getBoardById(@PathVariable("id") Long id) {
        return boardService.getBoardById(id);
    }



}

