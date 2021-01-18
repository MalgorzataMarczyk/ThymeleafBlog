package com.marczyk.forum.controller;


import com.marczyk.forum.dto.PublicationDto;
import com.marczyk.forum.exception.PublicationNotFoundException;
import com.marczyk.forum.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/edit_publication")
public class EditPublicationController {

    @Autowired
    BlogRepository blogRepository;

    @ExceptionHandler(PublicationNotFoundException.class)
    String publicationNotFound(){
        return "publicationNotFound";
    }

    @GetMapping
    String getEditPublication(@RequestParam("uuid") String uuid, Model model) throws PublicationNotFoundException {

        Optional<PublicationDto> optionalPublicationDto = blogRepository.getPublication(uuid);

        PublicationDto publicationDto = optionalPublicationDto.orElseThrow(PublicationNotFoundException::new);
        model.addAttribute("publication",publicationDto);

        return "editPublication";
    }

}
