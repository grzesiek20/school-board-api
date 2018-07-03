package services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import dao.PanelDAO;
import entities.Panel;


@Path("/api")
public class PanelService {

	@Inject
	 private PanelDAO dao;
	
	 @POST
		@Path("/panel")
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
		public Response createPanel(Panel panel) {
			Panel result = dao.addPanel(panel);
	        return Response.status(201).entity(result).build();
		}
	 
	 @GET
		@Path("/panel")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAll() {
			List<Panel> result = dao.getAll();
			if(result == null)
				return Response.noContent().build();
			else
				return Response.ok(result).build();
		}
	 
	 @GET
		@Path("/panel/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getPanel(@PathParam("id") Integer id) {
			Panel result = dao.getById(id);
		if(result!=null)
			return Response.ok(result).build();
		else
			return Response.noContent().build();
		}
	 
	 @PUT
	 @Path("/panel/{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response updateCustomer(@PathParam("id") Integer id, Panel panel) {
		 Panel result = dao.updatePanel(id, panel);
		 if(result == null)
			 return Response.serverError().build();
		 else
		 	 return Response.ok(result).build();
	 }
	 
	 @DELETE
	 @Path("/panel/{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response deletePanel(@PathParam("id") Integer id) {
		 Panel result = dao.deletePanel(id);
		 return Response.ok(result).build();
	 }
}
