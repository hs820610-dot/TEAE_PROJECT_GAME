package com.project.game.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FreeDTO {
    private int gameNo;
    private String gameTitle;
    private String gameContent;
    private String gameWriter;
    private String gamePasswd;
    private LocalDateTime gameDate;
    private int gameHits;
    private int gameRecommend;
}
