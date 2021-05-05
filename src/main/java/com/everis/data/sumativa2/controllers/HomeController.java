package com.everis.data.sumativa2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.sumativa2.models.Producto;
import com.everis.data.sumativa2.services.ProductoService;

@Controller
public class HomeController {
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("/")
	public String inicio() {
		return "index.jsp";
	}
	
	@RequestMapping("/carrito")
	public String mostrarCarrito(Model model) {
		List<Producto> productos =productoService.findAll();
		model.addAttribute("listadoProductos",productos);
		float totalCarrito = 0;
		for(Producto elemento:productos ) {
			totalCarrito += elemento.getPrecio();
		}
		model.addAttribute("totalCarrito", totalCarrito);
		
		return "carrito.jsp";
	}

}
