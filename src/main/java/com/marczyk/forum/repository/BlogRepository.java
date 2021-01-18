package com.marczyk.forum.repository;

import com.marczyk.forum.dto.MessageDto;
import com.marczyk.forum.dto.PublicationDto;

import java.util.List;
import java.util.Optional;

public interface BlogRepository {
    //Publications//
    void addPost(PublicationDto publicationDto);
    void deletePublication(String uuid);
    void editPublication(PublicationDto publicationDto);
    Optional<PublicationDto> getPublication(String uid);
    List<PublicationDto> getListOfPublication();
    List<PublicationDto> getLastThreePublications();

    //Messages//
    void sendMessage(MessageDto messageDto);

}
