package com.dis.bot.model.age;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Document("progress")
@Data
@Builder
public class Progress {

    @Id
    private String id;
    private String characterName;

    private Integer level;
    private String path;




}
