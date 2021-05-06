package com.everis.data.sumativa2.controllers;

import javax.servlet.http.HttpSession;

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
	public String inicio(Model model, HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		
		return "categoria.jsp";
		}else
			return"login.jsp";
	}
	
	@RequestMapping("/insertar")
	public String agregarCategoria(@RequestParam("nombre")String nombre,
			Model model,
			HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		Categoria categoria =  new Categoria();
		categoria.setNombre(nombre);
		
		categoria = categoriaService.save(categoria);
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		return "categoria.jsp";
		}else {
			return "login.jsp";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable("id") Long id,
			Model model,
			HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		categoriaService.deleteById(id);
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		return "categoria.jsp";
		}	else {
			return "login.jsp";
		}
	
}
	
	@RequestMapping("/editar/{id}")
	public String editarCategoria(@RequestParam("newcat") String newcat,
			@PathVariable("id")Long id, Model model,
			HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		Categoria cat=categoriaService.findById(id);
		cat.setNombre(newcat);
		categoriaService.save(cat);
		model.addAttribute("listadoCategorias",categoriaService.findAll());

		return "categoria.jsp";
		
		}else {
			return "login.jsp";
		}

	}
	
}
