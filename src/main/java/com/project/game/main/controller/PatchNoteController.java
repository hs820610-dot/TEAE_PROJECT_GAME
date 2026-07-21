package com.project.game.main.controller;

import com.project.game.dto.PatchNoteDTO;
import com.project.game.service.PatchNoteService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("client/game")
public class PatchNoteController {
    private final PatchNoteService patchNoteService;

    @GetMapping("/patchList")
    public String patchList(Model model) {
        List<PatchNoteDTO> list = patchNoteService.patchList();
        model.addAttribute("patchList", list);
        return "client/game/patchList";
    }
    @GetMapping("/patch/{patchNumber}")
    public String patchDetail(@PathVariable int patchNumber, Model model) {
        PatchNoteDTO patchNoteDTO = patchNoteService.patchDetail(patchNumber);
        model.addAttribute("patch",patchNoteDTO);
        return "client/game/patchDetail";
    }
    @PostMapping("/delete")
    public String patchDelete(int patchNumber) {
        patchNoteService.patchDelete(patchNumber);
        return "redirect:client/game/patchList";
    }

}
