package com.marczyk.forum.controller;

import com.marczyk.forum.dto.PublicationDto;
import com.marczyk.forum.exception.PublicationNotFoundException;
import com.marczyk.forum.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/publication")
public class PublicationController {
    @Autowired
    BlogRepository blogRepository;

    @ExceptionHandler(PublicationNotFoundException.class)
    String publicationNotFound(){
        return "publicationNotFound";
    }


    @GetMapping
    String getPublication(@RequestParam("uuid") String uuid,
                          Model model) throws PublicationNotFoundException {
        Optional<PublicationDto> optionalPublicationDto = blogRepository.getPublication(uuid);
        if(optionalPublicationDto.isPresent()){
            PublicationDto publicationDto = optionalPublicationDto.get();
            model.addAttribute("publication",publicationDto);
        }
        else{
            throw new PublicationNotFoundException();
        }

        return "publication";
    }

    @PutMapping
    String putPublication(@ModelAttribute("publicationDTO")PublicationDto publicationDto){
        blogRepository.addPost(publicationDto);
        return "redirect:";
    }

    @PostMapping
    RedirectView postPublication(@ModelAttribute("publicationDTO")PublicationDto publicationDto,
                                 RedirectAttributes redirectAttributes){

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("publication");

        blogRepository.editPublication(publicationDto);
        redirectAttributes.addAttribute("uuid", publicationDto.getUuid());
        return redirectView;
    }

    @DeleteMapping
    String deletePublication(@RequestParam("uuid") String uuid){
        blogRepository.deletePublication(uuid);
        return "redirect:";
    }

}
