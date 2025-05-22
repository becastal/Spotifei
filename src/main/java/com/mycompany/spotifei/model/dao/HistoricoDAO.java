/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.model.dao;

import com.mycompany.spotifei.model.Conexao;
import com.mycompany.spotifei.model.entity.Musica;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author becastal
 */
public class HistoricoDAO {
	public ArrayList<String> listarCurtidas(int userId) throws SQLException {
		String sql
			= "SELECT m.titulo AS nome, c.curtido_em AS momento "
			+ "  FROM curtidas c "
			+ "  JOIN musica m ON m.id = c.musica_id "
			+ " WHERE c.usuario_id = ? "
			+ " ORDER BY c.curtido_em DESC ";
		ArrayList<String> lista = new ArrayList<>();
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

			st.setInt(1, userId);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					String nome = rs.getString("nome");
					Timestamp ts = rs.getTimestamp("momento");
					lista.add(nome + " - " + ts.toString());
				}
			}
		}
		return lista;
	}

	public ArrayList<String> listarDescurtidas(int userId) throws SQLException {
		String sql
			= "SELECT m.titulo AS nome, d.descurtido_em AS momento "
			+ "  FROM descurtidas d "
			+ "  JOIN musica m ON m.id = d.musica_id "
			+ " WHERE d.usuario_id = ? "
			+ " ORDER BY d.descurtido_em DESC ";
		ArrayList<String> lista = new ArrayList<>();
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

			st.setInt(1, userId);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					String nome = rs.getString("nome");
					Timestamp ts = rs.getTimestamp("momento");
					lista.add(nome + " - " + ts.toString());
				}
			}
		}
		return lista;
	}

	public ArrayList<String> listarPesquisas(int userId) throws SQLException {
		String sql
			= "SELECT descricao, buscado_em FROM historico_buscas "
			+ " WHERE usuario_id = ? "
			+ " ORDER BY buscado_em DESC LIMIT 10";
		ArrayList<String> res = new ArrayList<>();
		try (Connection c = Conexao.getConnection(); PreparedStatement st = c.prepareStatement(sql)) {
			st.setInt(1, userId);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					res.add(rs.getString("descricao")
						+ " - "
						+ rs.getTimestamp("buscado_em"));
				}
			}
		}
		return res;
	}
}
