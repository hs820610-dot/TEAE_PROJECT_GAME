package com.project.game.mapper;

import com.project.game.dto.FreeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FreeMapper {
    List<FreeDTO> freeList();

    FreeDTO freeDetail(int gameNo);

    int freeInsert(FreeDTO freeDTO);

    int freeUpdate(FreeDTO freeDTO);

    int freeDelete(int gameNo);
}
