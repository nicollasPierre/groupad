import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/teste")
public class ArquivoService {

	public ArquivoService() {
		// TODO Auto-generated constructor stub
	}
	@GET
	@Produces("text/plain")
	public String getArquivo(){
		
		return "Ola mundo";
	}

}
