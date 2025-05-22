/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.control;

import com.mycompany.spotifei.model.dao.UsuarioDAO;
import com.mycompany.spotifei.model.entity.Usuario;
import java.sql.SQLException;

/**
 *
 * @author becastal
 */
public class LoginController {
	private final UsuarioDAO dao = new UsuarioDAO();
	
	public boolean autenticar(String email, String senha) throws SQLException {
		return dao.autenticar(email, senha);
	}

	public Usuario queryEmail(String email) throws SQLException {
		return dao.queryEmail(email);
	}
}