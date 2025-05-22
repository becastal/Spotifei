/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.model.entity;

/**
 *
 * @author becastal
 */
public class Playlist {
	private int id;	
	private String nome;	
	private int userId;	

	public Playlist(int id, String nome, int userId) {
		this.id = id;
		this.nome = nome;
		this.userId = userId;
	}

	public Playlist(String nome, int userId) {
		this(0, nome, userId);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getUserId() {
		return userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
