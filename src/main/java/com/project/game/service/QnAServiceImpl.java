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

    @Override
    public QnADTO QnADetail(int noQnA) {
        qnAMapper.hitsUpdate(noQnA);
        QnADTO qnADTO = qnAMapper.QnADetail(noQnA)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return qnADTO;
    }

    @Override
    public int hitsUpdate(int noQnA) {
        return qnAMapper.hitsUpdate(noQnA);
    }

    @Override
    public int recommendUpdate(int noQnA) {
        return qnAMapper.recommendUpdate(noQnA);
    }

    @Override
    public int getRecommend(int noQnA) {
        return qnAMapper.getRecommend(noQnA);
    }
}
