package com.demo.gft.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tecnologia")
public class Tecnologia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tecnologia;
	
	private String nome_tecnologia;
	
	@OneToMany(mappedBy = "tecnologia")
	private List<Starter> starters = new ArrayList<>();
	
	public Tecnologia() {
		// TODO Auto-generated constructor stub
	}

	public Tecnologia(String nome_tecnologia) {
		super();
		this.nome_tecnologia = nome_tecnologia;
	}

	public Long getId_tecnologia() {
		return id_tecnologia;
	}

	public void setId_tecnologia(Long id_tecnologia) {
		this.id_tecnologia = id_tecnologia;
	}

	public String getNome_tecnologia() {
		return nome_tecnologia;
	}

	public void setNome_tecnologia(String nome_tecnologia) {
		this.nome_tecnologia = nome_tecnologia;
	}
	
	

}
