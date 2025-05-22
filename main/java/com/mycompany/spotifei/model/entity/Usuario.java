/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.model.entity;

/**
 *
 * @author becastal
 */
public class Usuario {
	private int id;	
	private String nome;
	private String email;
	private String senha;

	public Usuario(int id_, String nome_, String email_, String senha_) {
		this.id = id_;
		this.nome = nome_;
		this.email = email_;
		this.senha = senha_;
	}

	public Usuario(String nome_, String email_, String senha_) {
		this(0, nome_, email_, senha_);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setId(int id_) {
		this.id = id_;
	}

	public void setNome(String nome_) {
		this.nome = nome_;
	}

	public void setEmail(String email_) {
		this.email = email_;
	}

	public void setSenha(String senha_) {
		this.senha = senha_;
	}
}
