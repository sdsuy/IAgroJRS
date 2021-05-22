package com.remote;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.interfaz.UsuarioBeanRemote;

public class UsuarioCliente {
	
	UsuarioBeanRemote usuarioBean;
	
	public UsuarioCliente() {
		
		String context = "ejb:/IAgroEJB/UsuarioBean!com.interfaz.UsuarioBeanRemote";
		
		try {
			usuarioBean = (UsuarioBeanRemote)getInitialContext().lookup(context);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public UsuarioBeanRemote getBean() {
		return usuarioBean;
	}
	
	private static Context getInitialContext() throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		props.put(Context.PROVIDER_URL, "remote+http://127.0.0.1:8080");
		
		return new InitialContext(props);
	}

}
