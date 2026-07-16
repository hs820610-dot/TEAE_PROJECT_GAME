package com.project.game.service;

import com.project.game.dto.PatchNoteDTO;
import com.project.game.mapper.PatchNoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatchNoteServiceImpl implements PatchNoteService {
    private final PatchNoteMapper patchNoteMapper;

    public List<PatchNoteDTO> patchList() {
        return patchNoteMapper.patchList();
    }

    public PatchNoteDTO patchDetail(int patchNumber) {
        patchNoteMapper.upHits(patchNumber);

        return patchNoteMapper.patchDetail(patchNumber)
                .orElseThrow(() -> new IllegalAccessError("해당 게시글이 존재하지 않습니다."));
    }
}
