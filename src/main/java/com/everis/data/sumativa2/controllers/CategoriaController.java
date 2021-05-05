package com.everis.data.sumativa2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.sumativa2.models.Categoria;
import com.everis.data.sumativa2.services.CategoriaService;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String inicio(Model model) {
		
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		
		return "categoria.jsp";
	}
	
	@RequestMapping("/insertar")
	public String agregarCategoria(@RequestParam("nombre")String nombre,
			Model model) {
		Categoria categoria =  new Categoria();
		categoria.setNombre(nombre);
		
		categoria = categoriaService.save(categoria);
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		return "categoria.jsp";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable("id") Long id,
			Model model) {
		categoriaService.deleteById(id);
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		return "categoria.jsp";
	}
	
	@RequestMapping("/editar/{id}")
	public String editarCategoria(@RequestParam("newcat") String newcat,
			@PathVariable("id")Long id, Model model) {
		Categoria cat=categoriaService.findById(id);
		cat.setNombre(newcat);
		categoriaService.save(cat);
		model.addAttribute("listadoCategorias",categoriaService.findAll());

		return "categoria.jsp";
		
	}

}
