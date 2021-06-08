package com.axelor.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.html.View;

import com.axelor.model.Contact;
import com.axelor.service.ContactService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("/jsp")
public class ContactControllerJSP {
	
	@Inject
	ContactService contactService; 


	@GET
	@Path("contact")
	@Produces(MediaType.TEXT_HTML)
	public View displayAllContact() throws IOException {
		
		List<Contact> contactList = contactService.getAllContacts();	
		return new View("index.jsp",contactList,"contactList");
	}
	
	@GET
	@Path("contact/search")
	@Produces(MediaType.TEXT_HTML)
	public View  displayContact(@QueryParam("name") String name) throws IOException {
		
		System.out.println(name);
		List<Contact> contactList = contactService.getContactByName(name);	
		return new View("Search.jsp",contactList,"searchList");
	}
	
	@POST
	@Path("/contact")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public View insertContact(@FormParam("name") String name,@FormParam("number") long number){
		Contact contact =new Contact();
		contact.setName(name).setNumber(number);
		try {
			contactService.insertContact(contact);
		}
		catch(Exception e) {
			return new View("index.jsp","Error in adding contact","creationResult");
		}
		
		return new View("index.jsp","Contact Has been added","creationResult");
		
	}
	
	@GET
	@Path("/contact/delete/{id}")
	public Response deleteContact(@PathParam("id") int id) {
		try {
			contactService.deleteContact(id);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return Response.status(400).entity("Unable to delete").build();
		}
		
		return Response.ok().entity("deleted").build();
	}
	
	@PUT
	@Path("/contact/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateContact(@PathParam("id") int id,Contact contact) {
		try {
			contactService.updateContact(id,contact);
		}
		catch(Exception e) {
			System.out.println("msg:"+e.getMessage());
			return Response.status(400).entity("Unable to update").build();
		}
		
		List<Contact> contactList = contactService.getContact(id);	
		return Response.ok(contactList).build();
	}
}
