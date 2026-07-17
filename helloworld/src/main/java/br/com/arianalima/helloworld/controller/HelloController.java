package br.com.arianalima.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.arianalima.helloworld.model.Produto;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/produtos")
	public Produto getProduto() {
		Produto p = new Produto();
		p.setId(12345);
		p.setNome("Computador");
		p.setPreco(1500.0);
		
		return p;
	}
	
	@PostMapping("/produtos")
	public String addNewProduct(@RequestBody Produto p) {
		System.out.println("Produto recebido");
		System.out.println(p.getId() + "/" + p.getNome() + "/" + p.getPreco());
		return "ok";
	}
}
