package com.dis.bot.mensagensdocorvo.service;

import com.dis.bot.mensagensdocorvo.model.Progress;
import com.dis.bot.mensagensdocorvo.repository.mongo.ProgressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ProgressService {
    private final ProgressRepository repository;

    public ProgressService(ProgressRepository repository){
        this.repository = repository;
    }

    public void start(String memberName, String playerName) {
        repository.save(Progress.builder()
                        .id(UUID.randomUUID().toString())
                        .characterName(playerName)
                        .playerNickName(memberName)
                        .path("default")
                        .level(0)
                .build());
    }
}
