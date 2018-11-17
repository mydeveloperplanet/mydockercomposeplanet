package com.mydeveloperplanet.mydockercomposeplanet.repositories;

import com.mydeveloperplanet.mydockercomposeplanet.domain.Show;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveShowRepository extends ReactiveMongoRepository<Show, String> {

}
