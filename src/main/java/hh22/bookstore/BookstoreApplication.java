package hh22.bookstore;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh22.bookstore.domain.Book;
import hh22.bookstore.domain.BookRepository;
import hh22.bookstore.domain.Category;
import hh22.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {return (args) -> {
		
		Category wilderness = new Category("wilderness");
		Category leipominen = new Category("leipominen");
		Category biography = new Category("biography");
		
		crepository.save(wilderness);
		crepository.save(leipominen);
		crepository.save(biography);
		 
		 Book a = new Book("1234", "Matti Meikäläinen", "Meikäläisen Matin elämä ja teot", 2020, 25.5, biography);
		 Book b = new Book("1235", "Kisu Kirsikka", "Parhaat pullat", 2015, 15.8, leipominen);
		 Book c = new Book("1236", "Eräjorma", "Miten selvitä pakkasella", 2012, 20.5, wilderness);
		 
		 brepository.save(a);
		 brepository.save(b);
		 brepository.save(c);
	};
	}
	

}
