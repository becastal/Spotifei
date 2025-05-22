/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.control;

import com.mycompany.spotifei.model.dao.PlaylistDAO;
import com.mycompany.spotifei.model.entity.Musica;
import com.mycompany.spotifei.model.entity.Playlist;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author becastal
 */
public class PlaylistsController {
	private final PlaylistDAO dao = new PlaylistDAO();
	
	public int criarPlaylist(int usuarioId, String nome) throws SQLException {
		return dao.criar(new Playlist(nome, usuarioId));
	}

	public void deletarPlaylist(int playlistId) throws SQLException {
		dao.deletar(playlistId);
	}

	public void adicionarMusica(int playlistId, int musicaId) throws SQLException {
		dao.adicionarMusica(playlistId, musicaId);
	}

	public void removerMusica(int playlistId, int musicaId) throws SQLException {
		dao.removerMusica(playlistId, musicaId);
	}

	public ArrayList<Musica> listarMusicas(int playlistId) throws SQLException {
		return dao.listarMusicas(playlistId);
	}

	public ArrayList<Playlist> listarPlaylists(int userId) throws SQLException {
		return dao.listarPlaylists(userId);
	}
}
