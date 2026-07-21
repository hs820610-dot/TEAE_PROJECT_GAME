package com.project.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageRequestDTO {
    private String searchType="";
    private String keyword = "";

    private int page =1;
    private int size = 15;

    public int getOffset(){
        return (page - 1) * size;
    }
}
