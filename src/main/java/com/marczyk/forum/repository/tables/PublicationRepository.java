package com.marczyk.forum.repository.tables;

import com.marczyk.forum.dto.PublicationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<PublicationDto, String> {
    List<PublicationDto> findTop3ByOrderByLastModificationDateDesc();
}
