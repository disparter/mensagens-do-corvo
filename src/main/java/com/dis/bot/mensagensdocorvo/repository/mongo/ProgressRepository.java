package com.dis.bot.mensagensdocorvo.repository.mongo;

import com.dis.bot.mensagensdocorvo.model.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgressRepository extends MongoRepository<Progress, String> {
    Progress findByMemberId(String memberId);
}
