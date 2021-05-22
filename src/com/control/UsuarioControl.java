package com.control;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.entidad.Roles;
import com.entidad.Usuario;
import com.remote.UsuarioCliente;

@Path("/usuario")
public class UsuarioControl {
	
	UsuarioCliente usuario_;
	
	public UsuarioControl() {
		usuario_ = new UsuarioCliente();
	}
	
	@GET
	public List<Usuario> leerTodos() {
		
		String NOMBRE = "JUAN";
		String APELLIDO = "PEREZ";
		String DOCUMENTO = "12345678";
		String EMAIL = "admin@utec";
		String NICKNAME = "ADMIN";
		String CLAVE = "1234";
		
		Usuario usuario = new Usuario();
		usuario.setNombre(NOMBRE);
		usuario.setApellido(APELLIDO);
		usuario.setDocumento(DOCUMENTO);
		usuario.setEmail(EMAIL);
		usuario.setNickname(NICKNAME);
		usuario.setClave(CLAVE);
		usuario.setRol(Roles.ADMINISTRADOR);
		
		boolean creado = usuario_.getBean().create(usuario);
		
		NOMBRE = "PEDRO";
		APELLIDO = "GONZALES";
		DOCUMENTO = "12345679";
		EMAIL = "experto@utec";
		NICKNAME = "EXPERTO";
		CLAVE = "1111";
		
		usuario = new Usuario();
		usuario.setNombre(NOMBRE);
		usuario.setApellido(APELLIDO);
		usuario.setDocumento(DOCUMENTO);
		usuario.setEmail(EMAIL);
		usuario.setNickname(NICKNAME);
		usuario.setClave(CLAVE);
		usuario.setRol(Roles.EXPERTO);
		
		creado = usuario_.getBean().create(usuario);
		
		List<Usuario> usuarios = usuario_.getBean().readAll();
		
		return usuarios;
	}

}
