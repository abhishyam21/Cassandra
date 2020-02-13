package com.learning.database.repo;

import com.learning.database.model.PersonEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PeopleRepo extends CassandraRepository<PersonEntity,String> {
    PersonEntity findByName(String name);
}
