/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.control;

import com.mycompany.spotifei.model.dao.CurtidaDAO;
import com.mycompany.spotifei.model.dao.MusicaDAO;
import com.mycompany.spotifei.model.entity.Musica;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author becastal
 */
public class MusicasController {
	private final MusicaDAO musicaDAO = new MusicaDAO();
	private final CurtidaDAO curtidaDAO = new CurtidaDAO();

	public ArrayList<Musica> queryTitulo(String titulo) throws SQLException {
		return musicaDAO.queryTitulo(titulo);
	}

	public ArrayList<Musica> queryArtista(String nomeArtista) throws SQLException {
		return musicaDAO.queryArtista(nomeArtista);
	}

	public ArrayList<Musica> queryGenero(String genero) throws SQLException {
		return musicaDAO.queryGenero(genero);
	}

	public void inserirBusca(int usuarioId, String descricao) throws SQLException {
		musicaDAO.inserirBusca(usuarioId, descricao);
	}

	public boolean curtiu(int usuarioId, int musicaId) throws SQLException {
		return curtidaDAO.curtiu(usuarioId, musicaId);
	}

	public void curtir(int usuarioId, int musicaId) throws SQLException {
		curtidaDAO.curtir(usuarioId, musicaId);
	}	

	public void descurtir(int usuarioId, int musicaId) throws SQLException {
		curtidaDAO.descurtir(usuarioId, musicaId);
	}	
}
