package com.project.game.main.controller;

import com.project.common.dto.PageRequestDTO;
import com.project.common.dto.PageResponseDTO;
import com.project.game.dto.QnADTO;
import com.project.game.service.QnAService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client/QnA")
public class QnAController {

    private final QnAService qnAService;

    @GetMapping("/QnAList")
    public String QnAList(Model model, PageRequestDTO pageRequestDTO) {
        PageResponseDTO pageResponseDTO = qnAService.selectQnAList(pageRequestDTO);
        model.addAttribute("list", pageResponseDTO.getList());
        model.addAttribute("page", pageResponseDTO);
        return "/client/QnA/QnAList";
    }

    @GetMapping("/QnAWrite")
    public String QnAWrite(Model model){
        model.addAttribute("qnADTO", new QnADTO());
        return "/client/QnA/QnAWrite";
    }

    @PostMapping("/QnAWrite")
    public String QnAInsert(QnADTO qnADTO, Model model){
        qnAService.QnAInsert(qnADTO);
        return "redirect:/client/QnA/QnAList";
    }

    @GetMapping("/QnAModify/{noQnA}")
    public String QnAModify(@PathVariable("noQnA") int noQnA, Model model){
        QnADTO qnADTO = qnAService.QnAReDetail(noQnA);
        model.addAttribute("qnADTO", qnADTO);
        return "/client/QnA/QnAWrite";
    }

    @GetMapping("/QnAHit/{noQnA}")
    public String QnAHit(@PathVariable("noQnA") int noQnA, Model model){
        QnADTO qnADTO = qnAService.QnAReDetail(noQnA);
        System.out.println("=== QnA 정보: " + qnADTO);
        System.out.println("=== reDTO 답변 정보: " + qnADTO.getReDTO());
        model.addAttribute("qnADTO", qnADTO);
        return "/client/QnA/QnAHit";
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
        return qnAService.QnAUpdate(qnADTO)?"redirect:/client/QnA/QnAHit/"+no:"redirect:/client/QnA/QnAList";
    }

    @PostMapping("/pwdCheck")
    @ResponseBody
    public boolean pwdCheck(QnADTO qnADTO){
        int validity = qnAService.pwdCheck(qnADTO);
        return validity==1;
    }

}
