package com.axelor.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

   

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long number;

    public int getId() {
        return id;
    }

    public Contact setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public long getNumber() {
        return number;
    }

    public Contact setNumber(long number) {
        this.number = number;
        return this;
    }
    
    public Contact() {
	}

	@Override
   	public String toString() {
   		return "Contact [id=" + id + ", name=" + name + ", number=" + number + "]";
   	}
}
