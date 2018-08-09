package com.test.react.react;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.react.react.domain.Contact;
import com.test.react.react.repositories.ContactRepository;

@SpringBootApplication
public class ReactApplication implements CommandLineRunner {


	@Autowired
	ContactRepository co;
	public static void main(String[] args) {
		SpringApplication.run(ReactApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		Contact c = new  Contact ("super man","egypt","tanat", "01233364","super@yahoo.com");
		
		co.save(c);
		

		Contact c2 = new  Contact ("bat man","egypt","alex", "012364555","bat@yahoo.com");
		co.save(c2);

		Contact c3 = new  Contact ("spider man","italy","roma", "012363334","spider@yahoo.com");
		co.save(c3);

		Contact c4 = new  Contact ("flash man","franc","paris", "01236334","falsh@yahoo.com");
		co.save(c4);

		Contact c5 = new  Contact ("hulk man","germany","herford", "012333364","hulk@yahoo.com");
		co.save(c5);
		
		
	}
}
