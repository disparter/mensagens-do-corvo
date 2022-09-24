package com.dis.bot.repository.mongo;

import com.dis.bot.model.age.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgressRepository extends MongoRepository<Progress, String> {
}
