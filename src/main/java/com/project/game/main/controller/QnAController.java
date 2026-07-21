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
    public String QnAWrite(Model model){
        model.addAttribute("qnADTO", new QnADTO());
        return "game/QnAWrite";
    }

    @PostMapping("/QnAWrite")
    public String QnAInsert(QnADTO qnADTO, Model model){
        qnAService.QnAInsert(qnADTO);
        return "redirect:/game/QnAList";
    }

    @GetMapping("/QnAModify/{noQnA}")
    public String QnAModify(@PathVariable("noQnA") int noQnA, Model model){
        QnADTO qnADTO = qnAService.QnAReDetail(noQnA);
        model.addAttribute("qnADTO", qnADTO);
        return "game/QnAWrite";
    }


    @GetMapping("/QnAHit/{noQnA}")
    public String QnAHit(@PathVariable("noQnA") int noQnA, Model model){
        QnADTO qnADTO = qnAService.QnAReDetail(noQnA);
        model.addAttribute("qnADTO", qnADTO);
        return "game/QnAHit";
    }

    @PostMapping("/QnAHit/{noQnA}")
    @ResponseBody
    public int recommendUpdate(@PathVariable("noQnA") int noQnA, Model model){
        qnAService.recommendUpdate(noQnA);
        return qnAService.getRecommend(noQnA);
    }

    @PostMapping("/QnADelete/{noQnA}")
    @ResponseBody
    public String QnADelete(@PathVariable("noQnA") int noQnA){
        qnAService.QnADelete(noQnA);
        return "success";
    }

    @PostMapping("/QnAUpdate")
    public String QnAUpdate(QnADTO qnADTO, Model model){
        int no = qnADTO.getNoQnA();
        return qnAService.QnAUpdate(qnADTO)?"redirect:/game/QnAHit/"+no:"redirect:/game/QnAList";
    }


}
