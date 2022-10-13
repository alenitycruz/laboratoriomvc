package com.demo.gft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.gft.entity.Tecnologia;
import com.demo.gft.repository.TecnologiaRepository;

@Service
public class TecnologiaService {
	
	@Autowired
	private TecnologiaRepository tecnologiaRepository;
	
	public Tecnologia createTecnologia(Tecnologia tecnologia) {
		return tecnologiaRepository.save(tecnologia);
		
	}

	public List<Tecnologia> readyAll(){
		return tecnologiaRepository.findAll();
		
	}
	
	public Tecnologia readyId(Long id) throws Exception {
		Optional<Tecnologia> tecnologia = tecnologiaRepository.findById(id);
		
		if(tecnologia.isEmpty()) {
			throw new Exception("Tecnologia não encontrada.");

		}
		
		return tecnologia.get();
	}
	
	public void delete(Long id) {
		tecnologiaRepository.deleteById(id);
	}
}
