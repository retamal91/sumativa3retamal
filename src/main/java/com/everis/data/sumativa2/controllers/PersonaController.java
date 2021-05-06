package com.everis.data.sumativa2.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.sumativa2.models.Persona;
import com.everis.data.sumativa2.services.PersonaService;



@Controller
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	PersonaService pService;

	@RequestMapping("/registro")
	public String inicioPersona(Model model) {
		return "persona.jsp";
	}
	
	@RequestMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("persona") Persona persona) {
		System.out.println("persona - guardar");
		persona= pService.save(persona);
		
		return"index.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("email") String email,
			@RequestParam("password") String password
			){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEmail(email);
		persona.setPassword(password);
		
		persona= pService.save(persona);
		
		
		return "redirect:/persona/login";
	}
	
	///persona/login
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session,
			Model model) {
		System.out.println("testeando");
		//boolean respuesta = pService.autenticacion(email, password);
		
		
		if(pService.autenticacion(email, password)) {
			session.setAttribute("email", email);
			session.setAttribute("registrado",1);//boolean
			session.setAttribute("contador",100);
			
			String mail = (String) session.getAttribute("email");
			Integer registrado = (Integer) session.getAttribute("registrado");
			Integer contador = (Integer) session.getAttribute("contador");
		
			System.out.println(mail+" - "+registrado+" - "+contador);
			
			//model.addAttribute("registrado", true);
			return "index.jsp";
		}else {
			session.removeAttribute("registrado");
			session.setAttribute("registrado",0);
			//session.invalidate();
			model.addAttribute("mensaje", "Datos erroneos");
			return "login.jsp";
		}
		
	}
	///persona/login
	@GetMapping("/login")
	public String getLogin(HttpSession session) {
		session.setAttribute("registrado",0);
		System.out.println("getlogin");
		return "login.jsp";
	}
	
	@RequestMapping("/testeo")
	public String testeo() {
		return "index.jsp";
		}	

}