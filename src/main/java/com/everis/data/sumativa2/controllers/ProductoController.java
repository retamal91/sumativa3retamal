package com.everis.data.sumativa2.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	private static final int CANT_PRODUCTOS = 2;

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/{numeroPagina}")
	public String inicio(@PathVariable("numeroPagina") int numeroPagina,Model model,
			@ModelAttribute("producto")Producto prod ,
			HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		
		Page<Producto> productos= productoService.productosPaginados(numeroPagina-1, CANT_PRODUCTOS);
		
		int totalPagina= productos.getTotalPages();
		model.addAttribute("totalPagina", totalPagina);
		model.addAttribute("listadoProductos",productos);
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		return "producto.jsp";
		}else {
			return "login.jsp";
		}
	}
	
	@RequestMapping("/insertar")
	public String update(@ModelAttribute("producto")Producto prod, Model model,
			HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		productoService.save(prod);
		Page<Producto> productos= productoService.productosPaginados(0, CANT_PRODUCTOS);
		
		int totalPagina= productos.getTotalPages();
		model.addAttribute("totalPagina", totalPagina);
		model.addAttribute("listadoProductos",productos);
		model.addAttribute("listadoCategorias",categoriaService.findAll());

		return "redirect:/producto/1";
		}else {
			return "login.jsp";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Long id,
			@ModelAttribute("producto")Producto prod,
			Model model,
			HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		productoService.deleteById(id);
		Page<Producto> productos= productoService.productosPaginados(0, CANT_PRODUCTOS);
		
		int totalPagina= productos.getTotalPages();
		model.addAttribute("totalPagina", totalPagina);
		model.addAttribute("listadoProductos",productos);
		model.addAttribute("listadoCategorias",categoriaService.findAll());
		return "redirect:/producto/1";
		}else {
			return "index.jsp";
		}
	}
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model,
			HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		Producto prod= productoService.findById(id);
		
		List<Categoria> listaCategorias =  categoriaService.findAll();
		
		model.addAttribute("producto", prod);
		model.addAttribute("listaCategorias", listaCategorias);
		return "editproducto.jsp";
		}else {
			return "login.jsp";
		}
	}
	@RequestMapping("/update")
	public String update(@ModelAttribute("producto")Producto prod ,
			HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		productoService.save(prod);
		return "redirect:/producto/1";
		}else {
			return "login.jsp";
		}
	}
	
	@RequestMapping("/busqueda")
	public String buscarProductos(Model model, HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		return "productobusqueda.jsp";
		}else {
			return  "login.jsp";
		}
	}
	
	@RequestMapping("/busqueda/buscar")
	public String busquedaProductos(@RequestParam("busqueda") String busqueda,
			Model model, HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		List<Producto> productos = productoService.FilterbyCategoria(busqueda);
		System.out.println(productos);
		model.addAttribute("listaProductos",productos);
		return "productobusqueda.jsp";
		}else {
			return "login.jsp";
					}
		}
	}
	

