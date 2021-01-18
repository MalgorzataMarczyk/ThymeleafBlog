package com.marczyk.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDto {
    String title;
    String author;
    @Lob
    String text;
    Date lastModificationDate = new Date();
    @Id
    String uuid = UUID.randomUUID().toString();

}
