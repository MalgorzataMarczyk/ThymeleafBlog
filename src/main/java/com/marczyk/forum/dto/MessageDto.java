package com.marczyk.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    String name;
    String emailAddress;
    @Lob
    String text;
    Date date = new Date();
    @Id
    String uuid = UUID.randomUUID().toString();

}
