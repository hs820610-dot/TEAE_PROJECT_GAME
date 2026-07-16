package com.project.game.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class PatchNoteDTO {
    private int patchNumber; //번호
    private String patchTitle; //제목
    private String patchContent; //내용
    private String patchWriter; //글쓴이
    private String patchDate; // 시간
    private int patchHits; // 조회수
    private int patchRecommend; // 추천수
    private int patchPasswd; // 비밀번호
}
