package it.cascino.ws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import it.cascino.model.Articoli;



@Path("/ftocservice")
public class FtoCService{
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertFtoC() throws JSONException{
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32) * 5 / 9;
		jsonObject.put("F Value", fahrenheit);
		jsonObject.put("C Value", celsius);
		
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
/*	@Path("{f}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException{
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = (f - 32) * 5 / 9;
		jsonObject.put("F Value", f);
		jsonObject.put("C Value", celsius);
		
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}*/
	
	/*@Path("{f}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException{
		List<Articoli> articoliLs =  new ArrayList<Articoli>();
		articoliLs.add(new Articoli("art1 ", "desc1 "+f));
		//articoliLs.add(new Articoli("art2 "+f, "desc2 "));
		
		//String result = "@Produces(\"application/json\") " + jsonObject;
		//return Response.status(200).entity(result).build();
//		return Response.status(200).entity(jsonObject).build();
//		return Response.ok().entity(new GenericEntity<List<Articoli>>(articoliLs) {}).build();
		
		return Response.ok(articoliLs).build();
	}*/
	
	
	@Path("{f}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException{
		List<Articoli> articoliLs =  new ArrayList<Articoli>();
		articoliLs.add(new Articoli("art1 ", "desc1 "+f));
		//articoliLs.add(new Articoli("art2 "+f, "desc2 "));
		
		//String result = "@Produces(\"application/json\") " + jsonObject;
		//return Response.status(200).entity(result).build();
//		return Response.status(200).entity(jsonObject).build();
//		return Response.ok().entity(new GenericEntity<List<Articoli>>(articoliLs) {}).build();
		
		return Response.ok(articoliLs).build();
	}
	
}