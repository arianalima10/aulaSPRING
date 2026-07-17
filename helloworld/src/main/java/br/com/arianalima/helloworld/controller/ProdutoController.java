package br.com.arianalima.helloworld.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.arianalima.helloworld.model.Produto;

@RestController
public class ProdutoController {
	
	public ArrayList<Produto> database;
	
	public ProdutoController() {
		database = new ArrayList<>() {{
			add(new Produto(1, "Computador", 1500.0));
			add(new Produto(2, "Mouse", 50.0));
			add(new Produto(3, "Teclado", 100.0));
			add(new Produto(4, "Monitor", 500.0));
			add(new Produto(5, "Impressora", 350.0));
		}};
	}
	
	@GetMapping("/produtos")
	public ArrayList<Produto> recuperarTodos(){
		return database;
	}
	
	@GetMapping("/produtos/sort")
	public List<Produto> recupararOrdenado(@RequestParam(name="order", required = false) String order) {
		System.out.println("order = " + order);

		if (order == null) {
			return database;
		} else if (order.equals("asc")) {
			return database.stream().sorted(Comparator.comparing(Produto::getPreco)).toList();
		} else if (order.equals("desc")) {
			return database.stream().sorted(Comparator.comparing(Produto::getPreco).reversed()).toList();
		} else
			return null;
	}
	
	@GetMapping("/produtos/{id}")
	public Produto recuperarPeloId(@PathVariable int id) {
		return database.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}
	
	@PostMapping("/produtos")
	public Produto adicionarProduto(@RequestBody Produto novo) {
		database.add(novo);
		return novo;
	}
	
	@PutMapping("/produtos/{id}")
	public Produto alterarDados(@PathVariable int id, @RequestBody Produto produto) {
		int posicao = IntStream.range(0, database.size())
							   .filter(i -> database.get(i).getId() == id)
							   .findFirst()
							   .orElse(-1);
		if(posicao >= 0) {
			database.set(posicao, produto);
			return produto;
		}
		return null;
	}
	
	@DeleteMapping("/produtos/{id}")
	public Produto apagarDados(@PathVariable int id) {
		int posicao = IntStream.range(0, database.size())
							   .filter(i -> database.get(i).getId() == id)
							   .findFirst()
							   .orElse(-1);
		if(posicao >= 0) {
			Produto tmp = database.get(posicao);
			database.remove(posicao);
			return tmp;
		}
		return null;
	}
	
	
	
}












