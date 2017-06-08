package br.com.furb.groupad.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClientesSingleton {
	private Set<Cliente> clientes = new LinkedHashSet<Cliente>();
	private static ClientesSingleton instance = new ClientesSingleton();
	
	private ClientesSingleton() {
	}
	
	public static synchronized ClientesSingleton getInstance(){
		if(instance == null){
			instance = new ClientesSingleton();
		}
		return instance;
	}
	
	public void addCliente(Cliente cliente){
		clientes.add(cliente);
	}
	
	public Set<Cliente> getClientes(){
		return clientes;
	}
	
	public boolean removeCliente(Cliente cliente){
		return clientes.remove(cliente);
	}
	
	public String showClientes(){
		String clientes = "";
		for (Cliente cliente : this.clientes) {
			clientes += cliente.getEndereco()+"&";
		}
		return clientes;
	}
	
	
	
	
}
