package com.everis.data.sumativa2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.sumativa2.models.Usuario;
import com.everis.data.sumativa2.repositories.UsuarioRepository;



@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
