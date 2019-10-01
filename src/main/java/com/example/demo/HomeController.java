package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class HomeController {
    @GetMapping("/tvform")
    public String loadTvForm(Model model) {
        model.addAttribute("tvshow", new Tvshow());
        return "tvform";
    }

    @PostMapping("/tvform")
    //Here, you don't see @ModelAttribute to pass what was previously done in the @GetMappping,
    // because @Valid is doing that for you this time, along with BidingResult.
    public String processTvForm(@Valid Tvshow tvshow,
                                BindingResult result){
        if (result.hasErrors()) {
            return "tvform";
        }
        return "tvshowconfirm";
    }
}
