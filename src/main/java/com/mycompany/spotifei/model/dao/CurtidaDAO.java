/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.model.dao;

import com.mycompany.spotifei.model.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author becastal
 */
public class CurtidaDAO {
	public boolean curtiu(int usuarioId, int musicaId) throws SQLException {
		String sql
			= "SELECT 1 FROM curtidas "
			+ " WHERE usuario_id = ? AND musica_id = ?";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

			st.setInt(1, usuarioId);
			st.setInt(2, musicaId);

			try (ResultSet rs = st.executeQuery()) {
				return rs.next();
			}
		}
	}

	public void curtir(int usuarioId, int musicaId) throws SQLException {
		String sql = "INSERT INTO curtidas(usuario_id, musica_id) "
			+ "VALUES (?, ?) "
			+ "ON CONFLICT DO NOTHING";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

			st.setInt(1, usuarioId);
			st.setInt(2, musicaId);
			st.executeUpdate();
		}
	}	

	public void descurtir(int usuarioId, int musicaId) throws SQLException {
		String sql = "DELETE FROM curtidas "
			+ " WHERE usuario_id = ? AND musica_id = ?";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, usuarioId);
			st.setInt(2, musicaId);
			st.executeUpdate();
		}
	
		String sql_ = "INSERT INTO descurtidas(usuario_id, musica_id) "
			+ "VALUES (?, ?) "
			+ "ON CONFLICT DO NOTHING";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql_)) {
			st.setInt(1, usuarioId);
			st.setInt(2, musicaId);
			st.executeUpdate();
		}
	}	
}