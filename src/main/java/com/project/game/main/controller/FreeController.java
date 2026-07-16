package com.project.game.main.controller;

import com.project.game.dto.FreeDTO;
import com.project.game.service.FreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/LOL")
@RequiredArgsConstructor
public class FreeController {
    private final FreeService freeService;

    @GetMapping("/free")
    public String main(Model model) {
        List<FreeDTO> list = freeService.freeList();
        model.addAttribute("list", list);
        return "client/free/freeBoard";
    }

    @GetMapping("/free/write")
    public String write(Model model) {
        model.addAttribute("free", new FreeDTO());
        return "client/free/write";
    }

    @PostMapping("/free/write")
    public String writeUpload(Model model, FreeDTO freeDTO) {
        freeService.freeInsert(freeDTO);
        return "redirect:/LOL/free";
    }

    @GetMapping("/free/detail/{gameNo}")
    public String detail(@PathVariable int gameNo, Model model) {
        FreeDTO freeDTO = freeService.freeDetail(gameNo);
        model.addAttribute("free", freeDTO);

        return "client/free/detail";
    }

    @PostMapping("/free/delete/{gameNo}")
    public String detailDelete(@PathVariable int gameNo) {
        freeService.freeDelete(gameNo);

        return "redirect:/LOL/free";
    }

    @GetMapping("/free/update/{gameNo}")
    public String updateForm(@PathVariable int gameNo, Model model) {
        FreeDTO free = freeService.freeDetail(gameNo); // 상세 조회
        model.addAttribute("free", free);

        return "client/free/update";
    }

    @PostMapping("/free/update/{gameNo}")
    public String update(@ModelAttribute FreeDTO freeDTO) {
        int num = freeDTO.getGameNo();
        freeService.freeUpdate(freeDTO);

        return "redirect:/LOL/free/detail/" + num;
    }

}
