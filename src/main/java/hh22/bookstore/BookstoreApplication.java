package hh22.bookstore;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh22.bookstore.domain.Book;
import hh22.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {return (args) -> {
		
		 
		 Book a = new Book("1234", "Matti Meikäläinen", "Meikäläisen Matin elämä ja teot", 2020, 25.5);
		 Book b = new Book("1235", "Kisu Kirsikka", "Parhaat pullat", 2015, 15.8);
		 Book c = new Book("1236", "Eräjorma", "Miten selvitä pakkasella", 2012, 20.5);
		 
		 repository.save(a);
		 repository.save(b);
		 repository.save(c);
	};
	}
	

}
