package com.axelor.service.impl;

import com.axelor.model.Contact;
import com.axelor.service.ContactService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Email;

import java.util.List;
import java.util.Optional;

@Singleton
public class ContactServiceImpl implements ContactService {

    @Inject
    Provider<EntityManager> emp;

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        EntityManager em = emp.get();
        Query query =  em.createQuery("Select c from Contact c order by c.id asc");
        List<Contact> contactList = (List<Contact>) query.getResultList();
        em.close();
        return contactList;
    }
    
    
	@Override
    @Transactional
    public List<Contact> getContact(int id) {
        EntityManager em = emp.get();
        Query query =  em.createQuery("select c from Contact c where id="+id);
        List<Contact> contactList =(List<Contact>) query.getResultList();
        return contactList;
    }
    
    
	@Override
    @Transactional
    public void insertContact(Contact contact) {
    	EntityManager em = emp.get();
    	em.persist(contact);
    	em.close();
    }


	@Override
	@Transactional
	public void deleteContact(int id) {
		EntityManager em = emp.get();
		Contact contact=em.find(Contact.class, id);
		em.remove(contact);
		em.close();
	}


	@Override
	@Transactional
	public void updateContact(int id, Contact contact) {
		EntityManager em = emp.get();
		Contact old=em.find(Contact.class, id);
		if(contact.getName()!=null) {
			old.setName(contact.getName());
		}
		if(contact.getNumber()!=0) {
			old.setNumber(contact.getNumber());
		}
		em.close();

	}


	@Override
	@Transactional
	public List<Contact> getContactByName(String name) {
		EntityManager em = emp.get();
		Query query=em.createQuery("Select c from Contact c where name=:name");
		query.setParameter("name", name);
		List<Contact> contactList=(List<Contact>) query.getResultList();
		return contactList;
	}
}
