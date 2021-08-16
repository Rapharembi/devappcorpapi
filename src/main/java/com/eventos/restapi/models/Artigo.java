/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventos.restapi.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author raphael.rembischewski
 */
@Entity
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    int ordemVolume;
    
    @Column(nullable=false, length=2)
    String idioma;

    @Column(nullable=false)
    String tituloPt;

    @Column(nullable=false)
    String tituloIng;
    
    @Column(nullable=false, length=2048)
    String resumoPt;
    
    @Column(nullable=false, length=2048)
    String resumoIng;
    
    // Palavras chave separadas pelo caracter ";"
    @Column(nullable=false, length=256)
    String pchavePt;
    
    // Palavras chave separadas pelo caracter ";"
    @Column(nullable=false, length=256)
    String pchaveIng;
    
    int numPaginas;
    
    @OneToMany(mappedBy="artigo", cascade = CascadeType.ALL)
    List<Autor> autores;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
    Volume volume;
    
    public Artigo() {}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrdemVolume() {
        return ordemVolume;
    }

    public void setOrdemVolume(int ordem) {
        this.ordemVolume = ordem;
    }

    public String getIdioma() {
        return idioma;
    }

  
    public void setIdioma(String idioma) {
        if(idioma.matches("pt|en|es")) {
     	this.idioma = idioma;
        }
        else {
     	   System.out.println("Idioma inválido");
        }
     }
    
    public String getTituloOriginal() {
        return tituloPt;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloPt = tituloOriginal;
    }

    public String getTituloIng() {
        return tituloIng;
    }

    public void setTituloIng(String tituloIngles) {
        this.tituloIng = tituloIngles;
    }

    public String getResumoPt() {
        return resumoPt;
    }

    public void setResumoPt(String resumoOriginal) {
        this.resumoPt = resumoOriginal;
    }

    public String getResumoIng() {
        return resumoIng;
    }

    public void setResumoIng(String resumoIngles) {
        this.resumoIng = resumoIngles;
    }

    public String getPchavePt() {
        return pchavePt;
    }

    public void setPChavePT(String pChavePT) {
       this.pchavePt = pChavePT;
    }

    public String getPchaveIng() {
        return pchaveIng;
    }

    public void setPChaveIng(String pChaveIng) {
        this.pchaveIng = pChaveIng;
    }

    public int getQuantidadePaginas() {
        return numPaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.numPaginas = quantidadePaginas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }
}