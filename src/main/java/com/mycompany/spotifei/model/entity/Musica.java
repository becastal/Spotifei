/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spotifei.model.entity;

/**
 *
 * @author becastal
 */
public class Musica {
	private int id;	
	private String titulo;
	private String genero;
	private Artista artista;

	public Musica(int id, String titulo, String genero, Artista artista) {
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.artista = artista;
	}

	public Musica(String titulo, String genero, Artista artista) {
		this(0, titulo, genero, artista);
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getGenero() {
		return genero;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
}
