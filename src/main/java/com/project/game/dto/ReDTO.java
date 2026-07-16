package com.project.game.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReDTO {
    private int reNoQnA;
    private String reContentQnA;
    private String reWriterQnA;
    private String reDateQnA;
    private String rePasswdQnA;
}
