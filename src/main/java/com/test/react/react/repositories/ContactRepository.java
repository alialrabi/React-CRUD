package com.test.react.react.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.react.react.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, String> {
	@Override
	void delete(Contact deleted);
	@Query(value="select * from contact where id = ?1" ,nativeQuery=true)
	Contact findId(Long id);
}