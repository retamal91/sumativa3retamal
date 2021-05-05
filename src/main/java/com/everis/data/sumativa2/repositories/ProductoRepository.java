package com.everis.data.sumativa2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.data.sumativa2.models.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	List<Producto> findByCategoriasNombre(String nombre);
}
