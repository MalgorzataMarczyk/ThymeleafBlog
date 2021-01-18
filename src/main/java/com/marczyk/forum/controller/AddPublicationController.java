package com.marczyk.forum.controller;


import com.marczyk.forum.dto.PublicationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddPublicationController {

    @GetMapping("/add_publication")
    String GetAddPublication(Model model){
        model.addAttribute("publicationDTO", new PublicationDto());
        return "addPublication";
    }
}
