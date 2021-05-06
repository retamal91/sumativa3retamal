package com.everis.data.sumativa2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.everis.data.sumativa2.models.Producto;
import com.everis.data.sumativa2.repositories.CategoriaRepository;
import com.everis.data.sumativa2.repositories.ProductoRepository;



@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	public Page<Producto> productosPaginados(int numeroPagina , int cantElementos){
		
		//obtener todos los productos y ordenarlos por nombre de forma ascendente
		PageRequest pageRequest = PageRequest.of(numeroPagina, cantElementos);
		
		return productoRepository.findAll(pageRequest);
	}
	


	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public void deleteById(Long id) {
		productoRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	public Producto findById(Long id) {
		return productoRepository.findById(id).get();
	}

	public List<Producto> FilterbyCategoria(String busqueda) {
		List<Producto> producto = productoRepository.findByCategoriasNombre(busqueda);
		System.out.println(producto);
		System.out.println("prueba");
		return producto;

	}
}
