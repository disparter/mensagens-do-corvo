package com.dis.bot.service;

import com.dis.bot.repository.mongo.ProgressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProgressService {
    private final ProgressRepository repository;

    public ProgressService(ProgressRepository repository){
        this.repository = repository;
    }

}
