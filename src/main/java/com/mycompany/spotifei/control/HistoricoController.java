/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.control;

import com.mycompany.spotifei.model.dao.HistoricoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author becastal
 */
public class HistoricoController {
	HistoricoDAO dao = new HistoricoDAO();

	public ArrayList<String> listarCurtidas(int userId) throws SQLException {
		return dao.listarCurtidas(userId);
	}

	public ArrayList<String> listarDescurtidas(int userId) throws SQLException {
		return dao.listarDescurtidas(userId);
	}

	public ArrayList<String> listarPesquisas(int userId) throws SQLException {
		return dao.listarPesquisas(userId);
	}
}
