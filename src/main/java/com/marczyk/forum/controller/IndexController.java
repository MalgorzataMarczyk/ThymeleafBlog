package com.marczyk.forum.controller;

import com.marczyk.forum.dto.PublicationDto;
import com.marczyk.forum.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/")
    String GetIndex(Model model){
        model.addAttribute("publicationList", blogRepository.getLastThreePublications());
        return "index";
    }
}
