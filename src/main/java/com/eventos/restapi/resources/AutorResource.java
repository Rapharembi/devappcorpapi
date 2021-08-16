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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.eventos.restapi.models.Autor;


@RestController
@RequestMapping(value="/api")
//@Api(value="API Autores")
public class AutorResource {

	@Autowired
	AutorRepository autorrepo;
	
	@GetMapping("/autores")
	@ApiOperation(value="Retorna todos os autores")
	public List<Autor> listaArtigos(){
		return autorrepo.findAll();
	}
	
	@GetMapping("/autor/{id}")
	@ApiOperation(value="Retorna autor com determinado id")
	public Autor listaArtigoUnico(@PathVariable(value="id")int id){
		return autorrepo.findById(id);
	}
	
	@PostMapping("/autor")
	@ApiOperation(value="Guarda um novo autor")
	public Autor salvaArtigo(@RequestBody Autor autor) {
		return autorrepo.save(autor);
	}
	
	@DeleteMapping("/autor")
	@ApiOperation(value="Deleta um autor")
	public void deleteAutor(@RequestBody Autor autor) {
			autorrepo.delete(autor);
	}
	
	@PutMapping("/autor")
	@ApiOperation(value="Atualiza um autor")
	public Autor atualizaAutor(@RequestBody Autor autor) {
		return autorrepo.save(autor);
	}
	
}
