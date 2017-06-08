package br.com.furb.groupad.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {
	private String endereco;

	public Cliente(String endereco) {
		super();
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
