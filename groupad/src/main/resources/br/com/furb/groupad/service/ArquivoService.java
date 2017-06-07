package br.com.furb.groupad.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/arquivo")
public class ArquivoService {

	@GET
	@Produces("text/plain")
	public String getArquivo() {
		return "olaMundo";
	}
	
	@Path("{id}")
	@GET
	@Produces("text/plain")
	public String getNoticia(@PathParam("id") String id) {
		String conteudo;
		try {
			BufferedReader br = new BufferedReader(new FileReader(id));
		} catch (FileNotFoundException e) {
			//Files.createFile("/arquivos/"+id+".txt");
			e.printStackTrace();
		}
		return "";
	}

}
