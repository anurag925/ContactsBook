package com.axelor.service;

import com.axelor.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    public List<Contact> getAllContacts();

	public void insertContact(Contact contact);

	List<Contact> getContact(int id);

	public void deleteContact(int id);

	public void updateContact(int id, Contact contact);

	public List<Contact> getContactByName(String name);
    
    
}
