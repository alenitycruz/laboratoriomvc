package com.demo.gft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.gft.entity.Starter;
import com.demo.gft.repository.StarterRepository;

@Service
public class StarterService {
	
	@Autowired
	private StarterRepository starterRepository;
	
	
	public Starter create(Starter starter) {
		return starterRepository.save(starter);
		
	}
	
	public List<Starter> readyAll(){
		return starterRepository.findAll();
		
	}
	
	public Starter readId(Long id) throws Exception {
		Optional<Starter> starter = starterRepository.findById(id);
		
		if(starter.isEmpty()) {
			throw new Exception("Starter não encontrada.");
		}
		
		return starter.get();
	}
	
	public void delete(Long id) {
		starterRepository.deleteById(id);
		
	}
}
