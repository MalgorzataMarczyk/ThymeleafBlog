package com.marczyk.forum.controller;

import com.marczyk.forum.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllPublicationsController {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/all_publications")
    String getAllPublications(Model model){
        model.addAttribute("publicationList", blogRepository.getListOfPublication());
        return "allPublications";
    }
}
