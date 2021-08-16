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

import com.eventos.restapi.models.Artigo;

import com.eventos.restapi.models.Volume;
import com.eventos.restapi.repository.ArtigoRepository;
import com.eventos.restapi.repository.VolumeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Volumes")
public class VolumeResource {

	@Autowired
	VolumeRepository volumerepo;

	@Autowired
	ArtigoRepository artigorepo;

	@GetMapping("/volumes")
	@ApiOperation(value="Retorna todos os volumes")
	public List<Volume> listaVolumes() {
		return volumerepo.findAll();
	}

	@GetMapping("/volume/{Id}")
	@ApiOperation(value="Retorna um volume com determinado id")
	public Volume listaVolumeUnico(@PathVariable(value = "Id") int volumeId) {
		return volumerepo.findById(volumeId);
	}

	@PostMapping("/volume")
	@ApiOperation(value="Guarda um novo volume")
	public Volume createVolume(@RequestBody Volume volume) {
		return volumerepo.save(volume);
	}

	@PutMapping("/volume")
	@ApiOperation(value="Atualiza um volume existente")
	public Volume atualizaVolume(@RequestBody Volume volume) {
		return volumerepo.save(volume);
	}

	@DeleteMapping("/volume/{Id}")
	@ApiOperation(value="Deleta um volume")
	public void deletaVolume(@PathVariable(value="Id") long Id) {
			volumerepo.deleteById(Id);
	}

	@GetMapping("volume/{Id}/artigos")
	@ApiOperation(value="Retorna todos os artigos de um determinado volume")
	public List<Artigo> listaArtigosDeVolume(@PathVariable(value = "Id") long volumeId) {
		
		return artigorepo.findByVolumeId(volumeId);

	}
		
	@DeleteMapping("/volume/{Id}/artigos/{artigoId}")
	@ApiOperation(value="Remove um artigo de um volume")
	public void deletaArtigoDeVolume(@PathVariable(value="Id") long Id, @PathVariable(value="artigoId") long articleId) {
		
	artigorepo.deleteById(articleId);
	}


		
	

}