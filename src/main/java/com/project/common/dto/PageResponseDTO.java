package com.project.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private final List<E> list;
    private final PageRequestDTO pageRequestDTO;
    /*
    public PageResponseDTO(List<E> list, PageRequestDTO pageRequestDTO) {
        this.list = list;
        this.pageRequestDTO = pageRequestDTO;
    }
     */

    private final int startPage;
    private final int endPage;

    private final boolean previous;
    private final boolean next;

    private final int totalCount;
    private final int totalPage;

    public PageResponseDTO(List<E> list, PageRequestDTO pageRequestDTO, int totalCount) {
        this.list = list;
        this.pageRequestDTO = pageRequestDTO;
        this.totalCount = totalCount;

        int navigateSize = 5;
        int tempEnd = (int) (Math.ceil(pageRequestDTO.getPage() / (double) navigateSize)) * navigateSize;

        this.startPage = tempEnd - navigateSize + 1;
        this.totalPage = (int) Math.ceil((double) totalCount / pageRequestDTO.getSize());

        int realEnd = (totalPage == 0) ? 1 : totalPage;
        this.endPage = Math.min(tempEnd, realEnd);

        this.previous = this.startPage > 1;
        this.next = this.endPage < totalPage;
    }
}
