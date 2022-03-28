package com.ejemplo.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@RequestScoped
@Named(value = "usuario")
public class UsuarioBean {
	private String user, pass;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String validaLogin() {
		String redireccion = "login";

		if ((user.equals("admin") && (pass.equals("1234")))) {
			redireccion = "principal";
		} else {
			redireccion="errorLogin";
		}

		return redireccion;
	}
}
