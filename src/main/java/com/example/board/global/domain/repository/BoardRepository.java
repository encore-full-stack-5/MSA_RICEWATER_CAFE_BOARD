package com.example.board.global.domain.repository;

import com.example.board.global.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findByMemberId(Long memberId);
    List<Board> findBySubGroupId(Long subGroupId);

    List<Board> findByCafeId(Long cafeId);

    List<Board> findByBoardTitle(String boardTitle);
}
