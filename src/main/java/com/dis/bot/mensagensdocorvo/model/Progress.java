package com.dis.bot.mensagensdocorvo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("progress")
@Data
@Builder
public class Progress {

    @Id
    private String id;
    private Boolean active;

    private String memberId;
    private String memberUserName;
    private String characterName;
    private Integer level;
    private String path;

}
