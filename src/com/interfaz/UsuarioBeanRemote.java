package com.interfaz;

import javax.ejb.Remote;

import com.entidad.Usuario;

@Remote
public interface UsuarioBeanRemote extends IBean<Usuario> {

}
