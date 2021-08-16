package com.eventos.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.eventos.restapi.models.Volume;

public interface VolumeRepository extends JpaRepository<Volume, Long> {
	Volume findById(long id);
}