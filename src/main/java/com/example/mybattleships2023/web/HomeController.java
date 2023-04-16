package com.example.mybattleships2023.web;

import com.example.mybattleships2023.domain.bindingModel.UserLoginBindingModel;
import com.example.mybattleships2023.domain.viewModel.ShipView;
import com.example.mybattleships2023.domain.viewModel.StartBattleView;
import com.example.mybattleships2023.service.ShipService;
import com.example.mybattleships2023.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final CurrentUser currentUser;

    public HomeController(ShipService shipService, CurrentUser currentUser) {
        this.shipService = shipService;
        this.currentUser = currentUser;
    }


    @ModelAttribute
    public StartBattleView startBattleView() {
        return new StartBattleView();
    }



    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        } else {

            Long curUserId = currentUser.getId();
            List<ShipView> ownShips = shipService.getShipsOwnedBy(curUserId);
            List<ShipView> enemyShips = shipService.getEnemyShips(curUserId);
            List<ShipView> sortedAllShips = shipService.getAllSortedShips();

            model.addAttribute("ownedShips", ownShips);
            model.addAttribute("enemyShips", enemyShips);
            model.addAttribute("allShips", sortedAllShips);

            return "home";

        }

    }
}
