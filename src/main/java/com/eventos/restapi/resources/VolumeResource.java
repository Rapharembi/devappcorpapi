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

import com.eventos.restapi.models.Artigo;

import com.eventos.restapi.models.Volume;
import com.eventos.restapi.repository.ArtigoRepository;
import com.eventos.restapi.repository.VolumeRepository;


@RestController
@RequestMapping("/volumes")
public class VolumeResource {

	@Autowired
	VolumeRepository volumerepo;

	@Autowired
	ArtigoRepository artigorepo;

	@GetMapping("")
	public List<Volume> listaVolumes() {
		return volumerepo.findAll();
	}

	@GetMapping("/volume/{Id}")
	public Volume listaVolumeUnico(@PathVariable(value = "Id") int volumeId) {
		return volumerepo.findById(volumeId);
	}

	@PostMapping("/volume")
	public Volume createVolume(@RequestBody Volume volume) {
		return volumerepo.save(volume);
	}

	@PutMapping("/volume")
	public Volume atualizaVolume(@RequestBody Volume volume) {
		return volumerepo.save(volume);
	}

	@DeleteMapping("/volume")
	public void deletaVolume(@RequestBody Volume volume) {
			volumerepo.delete(volume);
	}

	@GetMapping("volume/{Id}/artigos")
	public List<Artigo> listaArtigosDeVolume(@PathVariable(value = "Id") long volumeId) {
		
		return artigorepo.findByVolumeId(volumeId);

	}
		
	@DeleteMapping("/volume/{Id}/artigos/{artigoId}")
	public void deletaArtigoDeVolume(@PathVariable(value="Id") long Id, @PathVariable(value="artigoId") long articleId) {
		
	artigorepo.deleteById(articleId);
	}


		
	

}