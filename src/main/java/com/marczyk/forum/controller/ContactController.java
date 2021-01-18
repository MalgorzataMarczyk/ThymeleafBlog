package com.marczyk.forum.controller;

import com.marczyk.forum.dto.MessageDto;
import com.marczyk.forum.repository.BlogRepository;
import com.marczyk.forum.repository.tables.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {
    @Autowired
    BlogRepository blogRepository;

    @GetMapping
    String getContact(Model model){
        model.addAttribute("messageDTO" , new MessageDto());
        return "contact";
    }

    @PutMapping
    String putMessage(@ModelAttribute("messageDTO") MessageDto messageDto){
        blogRepository.sendMessage(messageDto);
        return "redirect:";
    }
}
