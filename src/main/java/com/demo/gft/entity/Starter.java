package com.demo.gft.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_starter")
public class Starter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_starter;
	
	private String nome_starter;
	
	@ManyToOne
	@JoinColumn(name = "id_tecnologia")
	private Tecnologia tecnologia;
	
	public Starter() {
		// TODO Auto-generated constructor stub
	}

	public Starter(String nome_starter) {
		super();
		this.nome_starter = nome_starter;
	}

	public Long getId_starter() {
		return id_starter;
	}

	public void setId_starter(Long id_starter) {
		this.id_starter = id_starter;
	}

	public String getNome_starter() {
		return nome_starter;
	}

	public void setNome_starter(String nome_starter) {
		this.nome_starter = nome_starter;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	

}
