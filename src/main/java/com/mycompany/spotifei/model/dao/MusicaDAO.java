/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.model.dao;

import com.mycompany.spotifei.model.Conexao;
import com.mycompany.spotifei.model.entity.Artista;
import com.mycompany.spotifei.model.entity.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author becastal
 */
public class MusicaDAO {

	public ArrayList<Musica> queryTitulo(String titulo) throws SQLException {
		String sql
			= "SELECT m.id, m.titulo, m.genero, "
			+ "       a.id AS artista_id, a.nome AS artista_nome "
			+ "  FROM musica m "
			+ "  JOIN artista a ON m.artista_id = a.id "
			+ " WHERE LOWER(m.titulo) LIKE LOWER(?)";

		ArrayList<Musica> lista = new ArrayList<>();
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

			st.setString(1, "%" + titulo + "%");

			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					Artista artista = new Artista(
						rs.getInt("artista_id"),
						rs.getString("artista_nome")
					);
					Musica m = new Musica(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getString("genero"),
						artista
					);
					lista.add(m);
				}
			}
		}
		return lista;
	}

	public ArrayList<Musica> queryArtista(String nomeArtista) throws SQLException {
		String sql
			= "SELECT m.id, m.titulo, m.genero, "
			+ "       a.id AS artista_id, a.nome AS artista_nome "
			+ "  FROM musica m "
			+ "  JOIN artista a ON m.artista_id = a.id "
			+ " WHERE LOWER(a.nome) LIKE LOWER(?)";

		ArrayList<Musica> lista = new ArrayList<>();
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

			st.setString(1, "%" + nomeArtista + "%");

			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					Artista artista = new Artista(
						rs.getInt("artista_id"),
						rs.getString("artista_nome")
					);
					Musica m = new Musica(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getString("genero"),
						artista
					);
					lista.add(m);
				}
			}
		}
		return lista;
	}

	public ArrayList<Musica> queryGenero(String genero) throws SQLException {
		String sql
			= "SELECT m.id, m.titulo, m.genero, "
			+ "       a.id AS artista_id, a.nome AS artista_nome "
			+ "  FROM musica m "
			+ "  JOIN artista a ON m.artista_id = a.id "
			+ " WHERE LOWER(m.genero) LIKE LOWER(?)";

		ArrayList<Musica> lista = new ArrayList<>();
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

			st.setString(1, "%" + genero + "%");

			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					Artista artista = new Artista(
						rs.getInt("artista_id"),
						rs.getString("artista_nome")
					);
					Musica m = new Musica(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getString("genero"),
						artista
					);
					lista.add(m);
				}
			}
		}
		return lista;
	}

	public void inserirBusca(int usuarioId, String descricao) throws SQLException {
		String sql = "INSERT INTO historico_buscas(usuario_id, descricao) VALUES(?, ?)";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, usuarioId);
			st.setString(2, descricao);
			st.executeUpdate();
		}
	}
}
