/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.model.dao;

import com.mycompany.spotifei.model.Conexao;
import com.mycompany.spotifei.model.entity.Artista;
import com.mycompany.spotifei.model.entity.Musica;
import com.mycompany.spotifei.model.entity.Playlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author becastal
 */
public class PlaylistDAO {
	public int criar(Playlist p) throws SQLException {
		String sql = "INSERT INTO playlist(nome, usuario_id) VALUES(?, ?)";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, p.getNome());
			st.setInt(2, p.getUserId());
			st.executeUpdate();
			try (ResultSet keys = st.getGeneratedKeys()) {
				if (keys.next()) {
					return keys.getInt(1);
				} else {
					throw new SQLException("Falha ao criar playlist.");
				}
			}
		}
	}	

	public void deletar(int playlistId) throws SQLException {
		String sql = "DELETE FROM playlist WHERE id = ?";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, playlistId);
			st.executeUpdate();
		}
	}

	public void adicionarMusica(int playlistId, int musicaId) throws SQLException {
		String sql = "INSERT INTO playlist_musicas(playlist_id, musica_id) VALUES(?, ?) ON CONFLICT DO NOTHING";
		try (Connection c = Conexao.getConnection(); PreparedStatement st = c.prepareStatement(sql)) {
			st.setInt(1, playlistId);
			st.setInt(2, musicaId);
			st.executeUpdate();
		}
	}

	public void removerMusica(int playlistId, int musicaId) throws SQLException {
		String sql = "DELETE FROM playlist_musicas WHERE playlist_id = ? AND musica_id = ?";
		try (Connection c = Conexao.getConnection(); PreparedStatement st = c.prepareStatement(sql)) {
			st.setInt(1, playlistId);
			st.setInt(2, musicaId);
			st.executeUpdate();
		}
	}

	public ArrayList<Musica> listarMusicas(int playlistId) throws SQLException {
		String sql
			= "SELECT m.id, m.titulo, m.genero, "
			+ "       a.id AS artista_id, a.nome AS artista_nome "
			+ "  FROM playlist_musicas pm "
			+ "  JOIN musica m ON pm.musica_id = m.id "
			+ "  JOIN artista a ON m.artista_id = a.id "
			+ " WHERE pm.playlist_id = ?";
		ArrayList<Musica> out = new ArrayList<>();
		try (Connection c = Conexao.getConnection(); PreparedStatement st = c.prepareStatement(sql)) {
			st.setInt(1, playlistId);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					out.add(new Musica(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getString("genero"),
						new Artista(
							rs.getInt("artista_id"),
							rs.getString("artista_nome")
						)
					));
				}
			}
		}
		return out;
	}

	public ArrayList<Playlist> listarPlaylists(int usuarioId) throws SQLException {
		String sql = "SELECT id, nome, usuario_id FROM playlist WHERE usuario_id = ?";
		ArrayList<Playlist> out = new ArrayList<>();
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, usuarioId);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					out.add(new Playlist(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getInt("usuario_id")
					));
				}
			}
		}
		return out;
	}
}
