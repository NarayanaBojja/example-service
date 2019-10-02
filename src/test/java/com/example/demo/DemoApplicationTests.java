package com.example.demo;

import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.modal.Person;
import com.example.demo.service.ExampleService;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@MockBean
	private ExampleService exampleService;

	@Test
	public void getNameTest() {
		Person person = new Person();
		person.setName("Narayana");
		Mono<Person> nameMono = Mono.just(person);
		given(this.exampleService.name()).willReturn(nameMono);
		StepVerifier.create(exampleService.getName()).expectNext(person).verifyComplete();

	}

}
