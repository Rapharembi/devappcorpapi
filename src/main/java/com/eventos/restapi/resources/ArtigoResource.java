package com.eventos.restapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.eventos.restapi.models.Artigo;
import com.eventos.restapi.models.Autor;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Artigos")
@CrossOrigin(origins = "*")
public class ArtigoResource {

	@Autowired
	ArtigoRepository artigorepo;
	
	@Autowired
	AutorRepository autorrepo;
	
	
	@GetMapping("/artigos")
	@ApiOperation(value="Retorna todos os artigos")
	public List<Artigo> listaArtigos(){
		return artigorepo.findAll();
	}
	
	@GetMapping("/artigo/{id}")
	@ApiOperation(value="Retorna artigo com determinado id")
	public Artigo listaArtigoUnico(@PathVariable(value="id")long id){
		return artigorepo.findById(id);
	}
	
	@GetMapping("/artigo/{id}/autores")
	@ApiOperation(value="Retorna autores de um determinado artigo")
	public List<Autor> listaAutoresDeArtigo(@PathVariable(value="id")long id){
		return autorrepo.findByArtigoId(id);
	}
		
	@DeleteMapping("/artigo")
	@ApiOperation(value="Deleta um artigo")
	public void deletaArtigo(@RequestBody Artigo artigo) {
		artigorepo.delete(artigo);
	}
	
	@PostMapping("/artigo")
	@ApiOperation(value="Guarda um novo artigo")
	public Artigo salvaArtigo(@RequestBody Artigo artigo) {
		return artigorepo.save(artigo);
	}
	
	@PutMapping("/artigo")
	@ApiOperation(value="Atualiza um artigo")
	public Artigo atualizaArtigo(@RequestBody Artigo artigo) {
		return artigorepo.save(artigo);
	}
	
	@DeleteMapping("/artigo/{Id}/autores/{autorId}")
	@ApiOperation(value="Remove um autor de um artigo")
	public void deletaArtigoDeVolume(@PathVariable(value="Id") long Id, @PathVariable(value="autorId") long autorId) {
		
	autorrepo.deleteById(autorId);
	}
}
