/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.model.dao;
import com.mycompany.spotifei.model.Conexao;
import com.mycompany.spotifei.model.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author becastal
 */
public class UsuarioDAO {
	public int cadastrar(Usuario u) throws SQLException {
		String sql = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			st.setString(1, u.getNome());
			st.setString(2, u.getEmail());
			st.setString(3, u.getSenha());

			int resultado = st.executeUpdate();
			if (resultado == 0) {
				throw new SQLException("Erro no SQL. Nenhuma linha adicionada.");
			}

			try (ResultSet keys = st.getGeneratedKeys()) {
				if (keys.next()) {
					int id = keys.getInt(1);
					u.setId(id);
					return id;
				} else {
					throw new SQLException("e: Erro no SQL. Nao foi possivel criar id.");
				}
			}
		}
	}	

	public Usuario queryEmail(String email) throws SQLException {
		String sql = "SELECT id, nome, email, senha FROM usuario WHERE email = ?";
		try (Connection conn = Conexao.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

			st.setString(1, email);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return new Usuario(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("email"),
						rs.getString("senha")
					);
				}
				return null;
			}
		}
	}

	public boolean autenticar(String email, String senha) throws SQLException {
		Usuario u = queryEmail(email);
		return u != null && u.getSenha().equals(senha);
	}
}
