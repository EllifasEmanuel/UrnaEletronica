package Urna;

import java.awt.image.BufferedImage;

public class Candidato {
	
	private String nome;
	private int numero;
	private int qtdVotos;
	private BufferedImage foto;

	public Candidato() {

	}

	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getNome () {
		return this.nome;
	}

	public void setNumero (int numero) {
		this.numero = numero;
	}

	public int getNumero () {
		return this.numero;
	}

	public void setFoto (BufferedImage foto) {
		this.foto = foto;
	}
	
	public BufferedImage getFoto () {
		return this.foto;
	}
	
	public void votar() {
		this.qtdVotos++;
	}
	
	public int getVotos () {
		return this.qtdVotos;
	}
	
}
