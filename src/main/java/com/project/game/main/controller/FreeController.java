package com.project.game.main.controller;

import com.project.game.dto.FreeDTO;
import com.project.game.service.FreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/free/update/{gameNo}")
    public String detailUpdate(FreeDTO freeDTO) {
        freeService.freeUpdate(freeDTO);
        return "redirect:/LOL/free";
    }
}
