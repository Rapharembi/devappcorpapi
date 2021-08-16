package com.eventos.restapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.eventos.restapi.repository.AutorRepository;
import com.eventos.restapi.models.Autor;


@RestController
@RequestMapping(value="/autores")
public class AutorResource {

	@Autowired
	AutorRepository autorrepo;
	
	@GetMapping("")
	public List<Autor> listaArtigos(){
		return autorrepo.findAll();
	}
	
	@GetMapping("/autor/{id}")
	public Autor listaArtigoUnico(@PathVariable(value="id")int id){
		return autorrepo.findById(id);
	}
	
	@PostMapping("/autor")
	public Autor salvaArtigo(@RequestBody Autor autor) {
		return autorrepo.save(autor);
	}
	
	@DeleteMapping("/autor")
	public void deleteAutor(@RequestBody Autor autor) {
			autorrepo.delete(autor);
	}
	
	@PutMapping("/autor")
	public Autor atualizaAutor(@RequestBody Autor autor) {
		return autorrepo.save(autor);
	}
	
}
