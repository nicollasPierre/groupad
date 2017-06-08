package br.com.furb.groupad.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import br.com.furb.groupad.model.Cliente;
import br.com.furb.groupad.model.ClientesSingleton;


@Path("/arquivo")
public class ArquivoService {

	private final String repositorio = "C:/temp/";
	
	@GET
	@Produces("text/plain")
	public String getArquivo() {
		return "ola Mundo";
	}
	
	@Path("{id}")
	@GET
	@Produces("text/plain")
	public String getNoticia(@Context HttpServletRequest requestContext, @PathParam("id") String id) {
		ClientesSingleton clientes = ClientesSingleton.getInstance();
		clientes.addCliente(new Cliente(requestContext.getRemoteAddr()));
		String conteudo= "";
		File arquivo = new File(repositorio+id);
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			String auxiliar;
			while((auxiliar = br.readLine()) != null){
				conteudo += auxiliar + "\n";
			}
			br.close();
		} catch (FileNotFoundException e) {//Caso o arquivo que o usuario passou não exista, eu tento criar ele.
			try {
				arquivo.createNewFile();
			} catch (IOException e1) {
				System.out.println("Erro ao tentar criar arquivo: "+e1.getMessage());
				e1.printStackTrace();
			}
		} catch (IOException e){
			System.out.println("Erro ao tentar ler arquivo: "+e.getMessage());
			e.printStackTrace();
		}
		return conteudo;
	}
	
	@Path("{id}")
	@PUT
	@Consumes("text/plain")
	@Produces("text/plain")
	public String putArquivo(String conteudo, @PathParam("id") String id) {
		File arquivo = new File(repositorio+id);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))){
			bw.write(conteudo);
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "Erro ao encontrar arquivo: "+e.getMessage();
			
		} catch (IOException e){
			e.printStackTrace();
			return "Erro ao tentar ler arquivo: "+e.getMessage();
		}
		return "Arquivo editado com sucesso";
	}
	
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String deleteArquivo(@PathParam("id") String id) {
		File arquivo = new File(repositorio+id);
		try{
			if(arquivo.delete()){
				return "Arquivo excluido com sucesso";
			}else{
				return "Arquivo não foi excluido, verifique se o arquivo existia antes desse metodo ser chamado";
			}
		} catch (SecurityException e) {
			e.printStackTrace();
			return "Erro ao excluir arquivo: "+e.getMessage();
			
		}
		
	}
	
	@Path("{id}")
	@POST
	@Produces("text/plain")
	public String postArquivo(@PathParam("id") String id) {
		return "Metodo não implementado, use o metodo get no lugar (ele ira criar o arquivo caso ele não exista)";
	}

}
