package com.example.mybattleships2023.web;


import com.example.mybattleships2023.domain.bindingModel.ShipAddBindingModel;
import com.example.mybattleships2023.domain.serviceModel.ShipAddServiceModel;
import com.example.mybattleships2023.service.ShipService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipsController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipsController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addShip() {
        return "ship-add";
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }


    @PostMapping("/add")
    public String AddShip(@Valid ShipAddBindingModel shipAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || shipService.existShip(shipAddBindingModel)) {
            redirectAttributes
                    .addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }


        shipService.addShip(modelMapper.map(shipAddBindingModel, ShipAddServiceModel.class));


        return "redirect:/";
    }

}


//
//
//    @GetMapping("/ready/{id}")
//    public String ready(@PathVariable Long id){
//        orderService.ready(id);
//
//
//        return "redirect:/";
//    }