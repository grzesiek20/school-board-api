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

import dao.BodyDAO;
import entities.Body;


@Path("/api")
public class BodyService {

	@Inject
	 private BodyDAO dao;
	
	 @POST
		@Path("/body")
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
		public Response createPanel(Body body) {
			Body result = dao.addBody(body);
	        return Response.status(201).entity(result).build();
		}
	 
	 @GET
		@Path("/body")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAll() {
			List<Body> result = dao.getAll();
			if(result == null)
				return Response.noContent().build();
			else
				return Response.ok(result).build();
		}
	 
	 @GET
		@Path("/body/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getBody(@PathParam("id") Integer id) {
			Body result = dao.getById(id);
		if(result!=null)
			return Response.ok(result).build();
		else
			return Response.noContent().build();
		}
	 
	 @GET
		@Path("/body/panel/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAllByPanelId(@PathParam("id") Integer id) {
			List<Body> result = dao.getAllByPanelId(id);
		if(result!=null)
			return Response.ok(result).build();
		else
			return Response.noContent().build();
		}
	 
	 @PUT
	 @Path("/body/{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response updateBody(@PathParam("id") Integer id, Body body) {
		 Body result = dao.updateBody(id, body);
		 if(result == null)
			 return Response.serverError().build();
		 else
		 	 return Response.ok(result).build();
	 }
	 
	 @DELETE
	 @Path("/body/{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response deleteBody(@PathParam("id") Integer id) {
		 Body result = dao.deleteBody(id);
		 return Response.ok(result).build();
	 }
}
