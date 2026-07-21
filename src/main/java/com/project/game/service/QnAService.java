package com.project.game.service;

import com.project.common.dto.PageRequestDTO;
import com.project.common.dto.PageResponseDTO;
import com.project.game.dto.QnADTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QnAService {
    List<QnADTO> QnAList();
    int QnAInsert(QnADTO qnaDTO);
    int QnADelete(int noQnA);
    boolean QnAUpdate(QnADTO qnaDTO);
    int recommendUpdate(int noQnA);
    int getRecommend(int noQnA);
    QnADTO QnAReDetail(int noQnA);
    int pwdCheck(QnADTO qnaDTO);
    int countPage(PageRequestDTO pageRequestDTO);
    List<QnADTO> postList(PageRequestDTO pageRequestDTO);
    PageResponseDTO<>
}
