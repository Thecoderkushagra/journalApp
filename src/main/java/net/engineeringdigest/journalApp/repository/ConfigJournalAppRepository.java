package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.ConfigEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigEntity, ObjectId> {
}
