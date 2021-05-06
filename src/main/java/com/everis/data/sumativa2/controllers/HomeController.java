package com.everis.data.sumativa2.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.sumativa2.models.Persona;
import com.everis.data.sumativa2.models.Producto;
import com.everis.data.sumativa2.services.ProductoService;

@Controller
public class HomeController {
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("/")
		public String index(HttpSession session) {
			//session.invalidate();
			return "login.jsp";
		}
	
	@RequestMapping("/index")
	public String inicio(HttpSession session) {
		//session.invalidate();
		return "login.jsp";
	}

	
	@RequestMapping("/carrito")
	public String mostrarCarrito(Model model, HttpSession session) {
		List<Producto> productos =productoService.findAll();
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
			
			model.addAttribute("listadoProductos",productos);
			float totalCarrito = 0;
			for(Producto elemento:productos ) {
				totalCarrito += elemento.getPrecio();
			}
			model.addAttribute("totalCarrito", totalCarrito);
			
			return "carrito.jsp";
		}else {
			return "login.jsp";
		}
	}
	
	@RequestMapping("/registro")
	public String registro(@Valid @ModelAttribute("persona") Persona persona,Model model) {
		//model.addAttribute("persona", new Persona());
		return "registro.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("registrado",0);
		return "login.jsp";
	}
}
