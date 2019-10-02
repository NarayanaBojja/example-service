package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.modal.Person;

import reactor.core.publisher.Mono;

@Service
public class ExampleService {
	public Mono<Person> getName() {
		Mono<Person> nameMono = name();
		return nameMono.flatMap(per -> Mono.just(per)).onErrorResume(error -> {
			return Mono.error(new RuntimeException("Name not found"));
		});
	}

	public Mono<Person> name() {
		Person person = new Person();
		person.setName("Narayana");
		return Mono.just(person);
	}
}
