package com.systems.repo;

import com.systems.model.PostMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMongoRepository extends MongoRepository<PostMongo, String> {

}
