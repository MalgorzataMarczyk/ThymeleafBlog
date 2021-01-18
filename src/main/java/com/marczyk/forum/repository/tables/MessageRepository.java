package com.marczyk.forum.repository.tables;

import com.marczyk.forum.dto.MessageDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageDto, String> {
}
