package com.eventos.restapi.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

	@GetMapping("volume/{Id}")
	public Volume listaVolumeUnico(@PathVariable(value = "Id") int volumeId) {
		return volumerepo.findById(volumeId);
	}

	@PostMapping("volume")
	public Volume createVolume(@RequestBody Volume volume) {
		return volumerepo.save(volume);
	}

	@PutMapping("volume/{Id}")
	public Volume atualizaVolume(@PathVariable(value = "Id") long volumeId, @RequestBody Volume volume) {
			
		Volume existingVolume = volumerepo.findById(volumeId);

		volume.setId(volumeId);
		volume.setArtigos(existingVolume.getArtigos());

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

	@GetMapping("volume/{Id}/Artigos/{ArtigoId}")
	public Artigo getArtigoFromVolume(@PathVariable(value = "Id") long volumeId,
			@PathVariable(value = "ArtigoId") long ArtigoId) {
		
		Artigo existingArtigo = artigorepo.findById(ArtigoId);
		return existingArtigo;

	}

	@PostMapping("/volume/{Id}/Artigos")
	public Artigo createArtigoInVolume(@PathVariable(value = "Id") long volumeId,
			@RequestBody Artigo Artigo) {
		boolean existVolume = volumerepo.existsById(volumeId);
		if (!existVolume)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This volume not exist");

		Volume existingVolume = volumerepo.findById(volumeId);

		Artigo.setVolume(existingVolume);

		return artigorepo.save(Artigo);
	}

	@PutMapping("/volume/{Id}/Artigos/{ArtigoId}")
	public Artigo updateArtigoFromVolume(@PathVariable(value="Id") long volumeId, @PathVariable(value="ArtigoId") long ArtigoId, @RequestBody Artigo Artigo) {
				
		Volume ArtigoVolume = artigorepo.findById(ArtigoId).getVolume();
		Artigo.setId(ArtigoId);
		Artigo.setVolume(ArtigoVolume);

		return artigorepo.save(Artigo);
	}
	

}