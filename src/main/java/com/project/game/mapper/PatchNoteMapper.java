package com.project.game.mapper;

import com.project.game.dto.PatchNoteDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PatchNoteMapper {
    List<PatchNoteDTO> patchList();
    Optional<PatchNoteDTO> patchDetail(@Param("patchNumber") int patchNumber);
    int upHits(@Param("patchNumber") int patchNumber);
    int patchDelete(@Param("patchNumber") int patchNumber);
}
