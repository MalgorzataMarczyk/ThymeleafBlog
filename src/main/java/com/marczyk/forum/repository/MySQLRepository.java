package com.marczyk.forum.repository;

import com.marczyk.forum.dto.MessageDto;
import com.marczyk.forum.dto.PublicationDto;
import com.marczyk.forum.repository.tables.MessageRepository;
import com.marczyk.forum.repository.tables.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Primary
public class MySQLRepository implements BlogRepository {
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    MessageRepository messageRepository;

    @Override
    public void addPost(PublicationDto publicationDto) {

        publicationRepository.save(publicationDto);
    }

    @Override
    public Optional<PublicationDto> getPublication(String uid) {

        return publicationRepository.findById(uid);
    }

    @Override
    public List<PublicationDto> getListOfPublication() {
        return publicationRepository.findAll(Sort.by(Sort.Direction.DESC, "lastModificationDate"));
    }

    @Override
    public void deletePublication(String uuid) {
        publicationRepository.deleteById(uuid);
    }

    @Override
    public void editPublication(PublicationDto publicationDto) {
        publicationRepository.save(publicationDto);
    }

    @Override
    public List<PublicationDto> getLastThreePublications() {
        return publicationRepository.findTop3ByOrderByLastModificationDateDesc();
    }

    @Override
    public void sendMessage(MessageDto messageDto) {
        messageRepository.save(messageDto);
    }
}
