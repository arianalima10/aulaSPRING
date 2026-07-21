package br.com.arianalima.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arianalima.helloworld.services.IMessageService;

@RestController
public class HelloController {

	@Autowired
	@Qualifier("v2")
	private IMessageService service;

	@GetMapping("/hello")
	public String sayHello() {
		return service.sayCustomMessage("Hello World");
	}
}