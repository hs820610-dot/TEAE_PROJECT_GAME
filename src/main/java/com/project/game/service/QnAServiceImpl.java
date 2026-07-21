package com.project.game.service;

import com.project.game.dto.QnADTO;
import com.project.game.dto.ReDTO;
import com.project.game.mapper.QnAMapper;
import com.project.game.mapper.ReMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QnAServiceImpl implements QnAService {
    private final QnAMapper qnAMapper;
    private final ReMapper reMapper;

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
    public boolean QnAUpdate(QnADTO qnaDTO) {
        int no = qnaDTO.getNoQnA();
        if ("".equals(qnaDTO.getPasswdQnA())) {
            qnaDTO.setPasswdQnA(null);
        }
        qnAMapper.QnAUpdate(qnaDTO);
        return true;
    }

    @Override
    public int recommendUpdate(int noQnA) {
        return qnAMapper.recommendUpdate(noQnA);
    }

    @Override
    public int getRecommend(int noQnA) {
        return qnAMapper.getRecommend(noQnA);
    }

    @Override
    public QnADTO QnAReDetail(int noQnA) {
        qnAMapper.hitsUpdate(noQnA);
        QnADTO qnADTO = qnAMapper.QnADetail(noQnA)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 게시글입니다."));
        ReDTO reDTO = reMapper.replyDetail(noQnA);
        qnADTO.setReDTO(reDTO);
        return qnADTO;
    }
}
