package org.mooner.postboard.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.mooner.postboard.domain.board.dto.request.BoardRequest;
import org.mooner.postboard.domain.board.dto.response.BoardResponse;
import org.mooner.postboard.domain.board.entity.Board;
import org.mooner.postboard.domain.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void addBoard(BoardRequest req) {
        boardRepository.save(new Board(0, req.getTitle(), req.getContents(), LocalDateTime.now()));
    }

    public BoardResponse getBoard(long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContents(),
                board.getCreateAt()
        );
    }

    public List<BoardResponse> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> new BoardResponse(
                        board.getId(),
                        board.getTitle(),
                        board.getContents(),
                        board.getCreateAt()
                ))
                .toList();
    }
}
