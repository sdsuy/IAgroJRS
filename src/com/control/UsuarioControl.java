package com.control;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
		List<Usuario> usuarios = usuario_.getBean().readAll();
		
		return usuarios;
	}
	
	@POST
	public Response crearUno(Usuario usuario) {
		boolean creado = usuario_.getBean().create(usuario);
		
		if(creado) {
			Status status = Status.CREATED;
			return Response.status(status).entity(usuario).build();
		}
		Status status = Status.INTERNAL_SERVER_ERROR;
		return Response.status(status).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response borrarUno(@PathParam("id") Long id) {
		boolean borrado = usuario_.getBean().delete(id);
		if(borrado) {
			Status status = Status.NO_CONTENT;
			return Response.status(status).build();
		}
		Status status = Status.INTERNAL_SERVER_ERROR;
		return Response.status(status).build();
	}

}
