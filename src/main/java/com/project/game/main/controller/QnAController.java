package com.project.game.main.controller;

import com.project.game.dto.QnADTO;
import com.project.game.service.QnAService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/game")
public class QnAController {

    private final QnAService qnAService;

    @GetMapping("/QnAlist")
    public String QnAList(Model model) {
        List<QnADTO> list = qnAService.QnAList();
        model.addAttribute("list", list);
        return "game/QnAlist";
    }

}
