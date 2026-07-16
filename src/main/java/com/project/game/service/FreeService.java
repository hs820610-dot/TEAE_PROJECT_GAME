package com.project.game.service;

import com.project.game.dto.FreeDTO;
import com.project.game.mapper.FreeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FreeService {
    List<FreeDTO> freeList();

    int freeInsert(FreeDTO freeDTO);

    int freeUpdate(FreeDTO freeDTO);

    int freeDelete(int gameNo);

    FreeDTO freeDetail(int gameNo);

}
