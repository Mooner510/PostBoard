package org.mooner.postboard.domain.board.dto.request;

import lombok.Data;

@Data
public class BoardRequest {
    private String title;
    
    private String contents;
}