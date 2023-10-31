package com.ms.user.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailDTO {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
