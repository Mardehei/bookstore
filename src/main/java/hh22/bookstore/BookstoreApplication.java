package hh22.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh22.bookstore.domain.Book;
import hh22.bookstore.domain.BookRepository;
import hh22.bookstore.domain.Category;
import hh22.bookstore.domain.CategoryRepository;
import hh22.bookstore.domain.User;
import hh22.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {return (args) -> {
		
		log.info("save a couple of categorys");
		Category wilderness = new Category("wilderness");
		Category leipominen = new Category("leipominen");
		Category biography = new Category("biography");
		
		crepository.save(wilderness);
		crepository.save(leipominen);
		crepository.save(biography);
		
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.com", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.com","ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		 
		 Book a = new Book("1234", "Matti Meikäläinen", "Meikäläisen Matin elämä ja teot", 2020, 25.5, biography);
		 Book b = new Book("1235", "Kisu Kirsikka", "Parhaat pullat", 2015, 15.8, leipominen);
		 Book c = new Book("1236", "Eräjorma", "Miten selvitä pakkasella", 2012, 20.5, wilderness);
		 
		 brepository.save(a);
		 brepository.save(b);
		 brepository.save(c);
		 
		log.info("fetch all students");
		for (Book book : brepository.findAll()) {
			log.info(book.toString());
		}
		
		 
	};
	}
	

}
