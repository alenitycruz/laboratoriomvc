package com.demo.gft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.gft.entity.Starter;

@Repository
public interface StarterRepository extends JpaRepository<Starter, Long>{

}
