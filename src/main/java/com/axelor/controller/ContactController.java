package com.axelor.controller;


import java.io.IOException;
import java.util.List;

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

import org.jboss.resteasy.plugins.providers.html.View;

import com.axelor.model.Contact;
import com.axelor.service.ContactService;
import com.google.inject.Inject;

@Path("/")
public class ContactController {
	
	@Inject
	ContactService contactService; 


	@GET
	@Path("contact")
	@Produces(MediaType.TEXT_PLAIN)
	public Response displayAllContact() throws IOException {
		
		List<Contact> contactList = contactService.getAllContacts();	
		return Response.ok(contactList).build();
	}
	
	@GET
	@Path("contact/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> displayContact(@PathParam("id")int  id) throws IOException {
		
		List<Contact> contactList = contactService.getContact(id);	
		return contactList;
	}
	
	@POST
	@Path("/contact")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertContact(Contact contact){
		try {
			contactService.insertContact(contact);
		}
		catch(Exception e) {
			return Response.status(400).build();
		}
		
		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("/contact/{id}")
	public Response deleteContact(@PathParam("id") int id) {
		try {
			contactService.deleteContact(id);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return Response.status(400).entity("Unable to delete").build();
		}
		
		return Response.ok().build();
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
