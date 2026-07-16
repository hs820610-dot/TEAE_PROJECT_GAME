package com.project.game.service;

import com.project.game.dto.FreeDTO;
import com.project.game.mapper.FreeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeServiceImpl implements FreeService {
    private final FreeMapper freeMapper;

    @Override
    public List<FreeDTO> freeList() {
        return freeMapper.freeList();
    }

    @Override
    public FreeDTO freeDetail(int gameNo) {
        return freeMapper.freeDetail(gameNo);
    }

    @Override
    public int freeInsert(FreeDTO freeDTO) {
        return freeMapper.freeInsert(freeDTO);
    }

    @Override
    public int freeUpdate(FreeDTO freeDTO) {
        return freeMapper.freeUpdate(freeDTO);
    }

    @Override
    public int freeDelete(int gameNo) {
        return freeMapper.freeDelete(gameNo);
    }
}
