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
		for (Cliente cliente1 : this.clientes) {
			if(cliente1.getEndereco().equals(cliente.getEndereco())){
				return;
			}
		}
		clientes.add(cliente);
	}
	
	public Set<Cliente> getClientes(){
		return clientes;
	}
	
	public boolean removeCliente(Cliente cliente){
		return clientes.remove(cliente);
	}
	
	public boolean removeCliente(String endereco){
		for (Cliente cliente : clientes) {
			if(cliente.getEndereco().equals(endereco)){
				return clientes.remove(cliente);
			}
		}
		return false;
		
	}
	
	public String showClientes(){
		String clientes = "";
		for (Cliente cliente : this.clientes) {
			clientes += cliente.getEndereco()+"&";
		}
		return clientes;
	}
	
	
	
	
}
