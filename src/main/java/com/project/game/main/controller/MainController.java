package com.project.game.main.controller;

import com.project.game.dto.FreeDTO;
import com.project.game.mapper.FreeMapper;
import com.project.game.service.FreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/LOL")
@RequiredArgsConstructor
public class MainController {
    private FreeService freeService;

    @GetMapping("/main")
    public String main(Model model) {
        List<FreeDTO> list = freeService.freeList();
        model.addAttribute("list", list);
        return "free/main";
    }
}
