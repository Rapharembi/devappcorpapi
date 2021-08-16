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

import com.eventos.restapi.repository.ArtigoRepository;
import com.eventos.restapi.repository.AutorRepository;
import com.eventos.restapi.models.Artigo;
import com.eventos.restapi.models.Autor;

@RestController
@RequestMapping(value="/artigos")
public class ArtigoResource {

	@Autowired
	ArtigoRepository artigorepo;
	
	@Autowired
	AutorRepository autorrepo;
	
	
	@GetMapping("")
	public List<Artigo> listaArtigos(){
		return artigorepo.findAll();
	}
	
	@GetMapping("/artigo/{id}")
	public Artigo listaArtigoUnico(@PathVariable(value="id")long id){
		return artigorepo.findById(id);
	}
	
	@GetMapping("/artigo/{id}/autores")
	public List<Autor> listaAutoresDeArtigo(@PathVariable(value="id")long id){
		return autorrepo.findByArtigoId(id);
	}
		
	@DeleteMapping("/artigo")
	public void deletaArtigo(@RequestBody Artigo artigo) {
		artigorepo.delete(artigo);
	}
	
	@PostMapping("/artigo")
	public Artigo salvaArtigo(@RequestBody Artigo artigo) {
		return artigorepo.save(artigo);
	}
	
	@PutMapping("/artigo")
	public Artigo atualizaArtigo(@RequestBody Artigo artigo) {
		return artigorepo.save(artigo);
	}
}
