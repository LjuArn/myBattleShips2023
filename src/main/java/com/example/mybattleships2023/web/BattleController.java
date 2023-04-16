package com.example.mybattleships2023.web;

import com.example.mybattleships2023.domain.viewModel.StartBattleView;
import com.example.mybattleships2023.service.ButtleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BattleController {

    private final ButtleService buttleService;

    public BattleController(ButtleService buttleService) {
        this.buttleService = buttleService;
    }


    @PostMapping("/battle")
    public String Battle(@Valid StartBattleView startBattleView) {


        buttleService.attack(startBattleView);

        return "redirect:/home";
    }
}
