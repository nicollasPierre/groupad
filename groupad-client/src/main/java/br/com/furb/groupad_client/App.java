package br.com.furb.groupad_client;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;

import br.com.furb.groupad_client.utils.RestUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
        	RestUtils.putRestRequest("http://localhost:8080/groupad/arquivo/ggeasy", "Good game well played");
        	RestUtils.getRestRequest("http://localhost:8080/groupad/arquivo/ggeasy", MediaType.TEXT_PLAIN);
        	RestUtils.postRestRequest("http://localhost:8080/groupad/arquivo/ggeasy", "huehuehue");
        	RestUtils.deleteRestRequest("http://localhost:8080/groupad/arquivo/ggeasy", MediaType.TEXT_PLAIN);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
