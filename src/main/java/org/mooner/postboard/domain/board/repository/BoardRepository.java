package org.mooner.postboard.domain.board.repository;

import org.mooner.postboard.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
