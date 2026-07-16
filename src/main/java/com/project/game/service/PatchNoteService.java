package com.project.game.service;

import com.project.game.dto.PatchNoteDTO;

import java.util.List;

public interface PatchNoteService {
    List<PatchNoteDTO> patchList();
    PatchNoteDTO patchDetail(int patchNumber);
    int patchDelete(int patchNumber);

}
