package com.project.game.main.controller;

import com.project.game.dto.PatchNoteDTO;
import com.project.game.service.PatchNoteService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/game")
public class PatchController {
    private final PatchNoteService patchNoteService;

    @GetMapping("/List")
    public String patchList(Model model) {
        List<PatchNoteDTO> List = PatchNoteService.
    }

}
