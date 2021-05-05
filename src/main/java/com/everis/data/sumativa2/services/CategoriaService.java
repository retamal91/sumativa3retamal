package com.everis.data.sumativa2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.sumativa2.models.Categoria;
import com.everis.data.sumativa2.repositories.CategoriaRepository;



@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).get();
	}

}
