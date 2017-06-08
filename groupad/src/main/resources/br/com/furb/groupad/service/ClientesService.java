package br.com.furb.groupad.service;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.furb.groupad.model.Cliente;
import br.com.furb.groupad.model.ClientesSingleton;

@Path("/clientes")
public class ClientesService {
	@GET
	@Produces("application/json")
	public Set<Cliente> getArquivo() {
		System.out.println(ClientesSingleton.getInstance().showClientes());
		return ClientesSingleton.getInstance().getClientes();
	}

	@Path("{id}")
	@GET
	@Produces("text/plain")
	public String getNoticia(@PathParam("id") String id) {
		return "metodo não implementado";
	}

	@Path("{id}")
	@PUT
	@Consumes("text/plain")
	@Produces("text/plain")
	public String putArquivo(@PathParam("id") String id) {
		return "metodo não implementado";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String deleteArquivo(@PathParam("id") String id) {
		return "metodo não implementado";
	}

	@Path("{id}")
	@POST
	@Produces("text/plain")
	public String postArquivo(@PathParam("id") String id) {
		return "metodo não implementado";
	}
}
