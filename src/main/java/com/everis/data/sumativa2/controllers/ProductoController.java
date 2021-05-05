package com.everis.data.sumativa2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.sumativa2.models.Categoria;
import com.everis.data.sumativa2.models.Producto;
import com.everis.data.sumativa2.services.CategoriaService;
import com.everis.data.sumativa2.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String inicio(Model model,
			@ModelAttribute("producto")Producto prod ) {
		
		model.addAttribute("listadoProductos",productoService.findAll());
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		return "producto.jsp";
	}
	
	@RequestMapping("/insertar")
	public String update(@ModelAttribute("producto")Producto prod, Model model ) {
		productoService.save(prod);
		model.addAttribute("listadoProductos",productoService.findAll());
		model.addAttribute("listadoCategorias",categoriaService.findAll());

		return "redirect:";
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Long id,
			@ModelAttribute("producto")Producto prod,
			Model model) {
		productoService.deleteById(id);
		model.addAttribute("listadoProductos",productoService.findAll());
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		return "producto.jsp";
	}
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Producto prod= productoService.findById(id);
		
		List<Categoria> listaCategorias =  categoriaService.findAll();
		
		model.addAttribute("producto", prod);
		model.addAttribute("listaCategorias", listaCategorias);
		return "editproducto.jsp";
	}
	@RequestMapping("/update")
	public String update(@ModelAttribute("producto")Producto prod ) {
		productoService.save(prod);
		return "redirect:/producto";
	}
	
	@RequestMapping("/busqueda")
	public String buscarProductos(Model model) {
		return "productobusqueda.jsp";
	}
	
	@RequestMapping("/busqueda/buscar")
	public String busquedaProductos(@RequestParam("busqueda") String busqueda,
			Model model) {
		List<Producto> productos = productoService.FilterbyCategoria(busqueda);
		System.out.println(productos);
		model.addAttribute("listaProductos",productos);
		return "productobusqueda.jsp";
	}
	
}
