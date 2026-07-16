package com.project.game.main.controller;

import com.project.game.dto.QnADTO;
import com.project.game.service.QnAService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/game")
public class QnAController {

    private final QnAService qnAService;

    @GetMapping("/QnAList")
    public String QnAList(Model model) {
        List<QnADTO> list = qnAService.QnAList();
        model.addAttribute("list", list);
        return "game/QnAList";
    }

    @GetMapping("/QnAWrite")
    public String QnAWrite(){
        return "game/QnAWrite";
    }

    @PostMapping("/QnAWrite")
    public String QnAInsert(QnADTO qnADTO, Model model){
        qnAService.QnAInsert(qnADTO);
        return "redirect:/game/QnAList";
    }

    @GetMapping("/QnAHit/{noQnA}")
    public String QnAHit(@PathVariable("noQnA") int noQnA, Model model){
        QnADTO qnADTO = qnAService.QnADetail(noQnA);
        model.addAttribute("qnADTO", qnADTO);
        return "game/QnAHit";
    }

    @PostMapping("/QnAHit/{noQnA}")
    @ResponseBody
    public int recommendUpdate(@PathVariable("noQnA") int noQnA, Model model){
        qnAService.recommendUpdate(noQnA);
        return qnAService.getRecommend(noQnA);
    }

    @PostMapping("/QnAdelete/{noQnA}")
    @ResponseBody
    public String QnADelete(@PathVariable("noQnA") int noQnA){
        qnAService.QnADelete(noQnA);
        return "success";
    }

}
