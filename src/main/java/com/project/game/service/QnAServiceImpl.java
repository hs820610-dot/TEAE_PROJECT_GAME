package com.project.game.service;

import com.project.game.dto.QnADTO;
import com.project.game.mapper.QnAMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnAServiceImpl implements QnAService {
    private final QnAMapper qnAMapper;

    @Override
    public List<QnADTO> QnAList() {
        return qnAMapper.QnAList();
    }

    @Override
    public int QnAInsert(QnADTO qnaDTO) {
        return qnAMapper.QnAInsert(qnaDTO);
    }

    @Override
    public int QnADelete(int noQnA) {
        return qnAMapper.QnADelete(noQnA);
    }

    @Override
    public int QnAUpdate(QnADTO qnaDTO) {
        return qnAMapper.QnAUpdate(qnaDTO);
    }
}
