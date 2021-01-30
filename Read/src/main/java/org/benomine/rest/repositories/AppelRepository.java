package org.benomine.rest.repositories;

import org.benomine.rest.models.Appel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface AppelRepository extends MongoRepository<Appel, String>, QueryByExampleExecutor<Appel> {

}
