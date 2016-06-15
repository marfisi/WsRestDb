package it.cascino.ws;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;
import it.cascino.dbas.dao.AsAncab0fDao;
import it.cascino.dbas.model.AsAncab0f;

@Path("/bcodeserv")
public class BCodeServ{
	
	/**
	 * Logger
	 */
	@Inject
	private Logger log;
	
	@Inject
	private AsAncab0fDao asAncab0fDao;
	private List<AsAncab0f> asAncab0fLs;
	
	@Path("{bcode}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response articoloFromBarcode(@PathParam("bcode") String bcode){
		//Integer ccodb = Integer.parseInt(StringUtils.trimToEmpty(bcode));
		bcode = StringUtils.trimToEmpty(bcode);
		log.info("barcode: " + bcode);
		//asAncab0fLs.clear();
		asAncab0fLs = asAncab0fDao.getArticoloDaBarcode(bcode);
		
		return Response.ok(asAncab0fLs).build();
	}
	
}