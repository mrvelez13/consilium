package com.plurality.platform.webflux.app.user.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.plurality.platform.webflux.app.user.domain.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String>
{
	Mono<User> findByLogin(String login);
}
