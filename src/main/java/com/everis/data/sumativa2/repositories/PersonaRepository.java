package com.everis.data.sumativa2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.sumativa2.models.Persona;



@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

	Persona findByEmail(String email);

}