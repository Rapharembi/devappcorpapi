package com.eventos.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventos.restapi.models.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long>{
	
	Artigo findById(long id);
	List<Artigo> findByVolumeId (long vId);
}
