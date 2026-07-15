package com.project.game.service;

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
    int QnAUpdate(QnADTO qnaDTO);
}
