package br.com.furb.groupad.model;

import java.nio.file.Path;

public class Arquivo {
	Path caminho;
	public Arquivo() {
		// TODO Auto-generated constructor stub
	}
	
	public Arquivo(Path caminho) {
		super();
		this.caminho = caminho;
	}

	public Path getCaminho() {
		return caminho;
	}
	public void setCaminho(Path caminho) {
		this.caminho = caminho;
	}

	
}
