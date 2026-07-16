package com.project.game.main.controller;

import com.project.game.dto.FreeDTO;
import com.project.game.service.FreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/free/board")
    public String board(Model model) {
        List<FreeDTO> list = freeService.freeList();
        model.addAttribute("list", list);
        return "client/free/readboard";
    }
}
