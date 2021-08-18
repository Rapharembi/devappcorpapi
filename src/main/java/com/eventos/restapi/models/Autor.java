package com.eventos.restapi.models;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 *
 * @author raphael.rembischewski
 */
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    int ordemArtigo;
    
    @Column(nullable=false)
    String email;

    @Column(nullable=false, length=64)
    String primNome;

    @Column(nullable=false, length=2048)
    String meioNome;
    
    @Column(nullable=false, length=64)
    String ultiNome;
    
    @Column(nullable=false, length=256)
    String afiliacaoPt;
    
    @Column(nullable=false, length=256)
    String afiliacaoIng;
    
    @Column(nullable=false, length=2)
    String pais;
    
    String orcID;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
    Artigo artigo;
     
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    public static final Pattern VALID_ORCID_REGEX = 
    Pattern.compile("^[a-zA-Z]+-[a-zA-Z]+-[a-zA-Z]+-[a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
    
    public static boolean validateEmail(String email) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
    return matcher.find();
    }
    
    public static boolean validateOrcId(String orcid) {
        Matcher matcher = VALID_ORCID_REGEX.matcher(orcid);
        return matcher.find();
        }
    
    public Autor() {}
    
    public long getId() {
        return id;
    }

    public int getOrdemArtigo() {
		return ordemArtigo;
	}

	public void setOrdemArtigo(int ordemArtigo) {
		this.ordemArtigo = ordemArtigo;
	}

	public String getOrcID() {
		return orcID;
	}

	public void setOrcID(String orcID) {
		this.orcID = orcID;
	}

	public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)){
    	this.email = email;
        }
        else {
        	System.out.println("Email inválido");
        }
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
       
    	this.pais = pais;
    }
     

    public String getPrimNome() {
        return primNome;
    }

    public void setPrimNome(String primNome) {
        this.primNome = primNome;
    }

   
    public String getMeioNome() {
        return meioNome;
    }

    public void setMeioNome(String meioNome) {
        this.meioNome = meioNome;
    }

    public String getUltiNome() {
        return ultiNome;
    }

    public void setUltiNome(String ultiNome) {
        this.ultiNome = ultiNome;
    }

    public String getAfiliacaoPt() {
        return afiliacaoPt;
    }

    public void setAfiliacaoPt(String afiliacaoPT) {
        this.afiliacaoPt = afiliacaoPT;
    }

    public String getAfiliacaoIng() {
        return afiliacaoPt;
    }

    public void setAfiliacaoIng(String afiliacaoIng) {
        this.afiliacaoIng = afiliacaoIng;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

}