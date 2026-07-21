package com.project.game.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnADTO {
    private Integer noQnA;
    private String titleQnA;
    private String contentQnA;
    private String writerQnA;
    private String dateQnA;
    private int hitsQnA;
    private int recommendQnA;
    private String passwdQnA;
    private ReDTO reDTO;
}