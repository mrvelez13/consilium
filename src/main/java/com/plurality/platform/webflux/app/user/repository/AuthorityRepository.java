package com.plurality.platform.webflux.app.user.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.plurality.platform.webflux.app.user.domain.Authority;

public interface AuthorityRepository extends ReactiveMongoRepository<Authority, String>
{

}
