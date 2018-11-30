package com.plurality.platform.webflux.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api")
public class DemoController
{
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Mono<String> hello(@RequestParam String name) {
        return Mono.just("Hello " + name);
    }
}
