package com.project.game.mapper;

import com.project.game.dto.PatchNoteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatchNoteMapper {
    List<PatchNoteDTO> patchList();
}
