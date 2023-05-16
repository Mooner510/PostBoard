package org.mooner.postboard.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.mooner.postboard.domain.board.dto.request.BoardRequest;
import org.mooner.postboard.domain.board.dto.response.BoardResponse;
import org.mooner.postboard.domain.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public String addBoard(@RequestBody BoardRequest req) {
        boardService.addBoard(req);
        return "";
    }

    @GetMapping
    public BoardResponse getBoard(@RequestParam long id) {
        return boardService.getBoard(id);
    }

    @GetMapping("/all")
    public List<BoardResponse> getAllBoards() {
        return boardService.getAllBoards();
    }
}
