package com.test.react.react.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.react.react.domain.Contact;
import com.test.react.react.repositories.ContactRepository;

import java.util.Optional;

@CrossOrigin(maxAge = 3600)

@RestController
public class ContactController {

	@Autowired
	ContactRepository contactRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/contacts")
	public Iterable<Contact> contact() {
		return contactRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/contacts")
	public Contact save(@RequestBody Contact contact) {
		contactRepository.save(contact);

		return contact;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/contacts/{id}")
	public Contact show(@PathVariable Long id) {
		return contactRepository.findId(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/contacts/{id}")
	public Contact update(@PathVariable Long id, @RequestBody Contact contact) {
		Contact optcontact = contactRepository.findId(id);
		Contact c = optcontact;
		if (contact.getName() != null)
			c.setName(contact.getName());
		if (contact.getAddress() != null)
			c.setAddress(contact.getAddress());
		if (contact.getCity() != null)
			c.setCity(contact.getCity());
		if (contact.getPhone() != null)
			c.setPhone(contact.getPhone());
		if (contact.getEmail() != null)
			c.setEmail(contact.getEmail());
		contactRepository.save(c);
		return c;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/contacts/{id}")
	public String delete(@PathVariable Long id) {
		Contact contact = contactRepository.findId(id);
		contactRepository.delete(contact);

		return "";
	}
}