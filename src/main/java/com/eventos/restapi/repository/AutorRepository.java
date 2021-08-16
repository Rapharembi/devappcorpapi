package com.eventos.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventos.restapi.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	Autor findById(long id);

}
