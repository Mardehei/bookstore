package hh22.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh22.bookstore.domain.Book;
import hh22.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired 
	private BookRepository repository;	
	
	@RequestMapping(value = "/bookstore", method = RequestMethod.GET) 
	public String Books(Model model) {	
		model.addAttribute("books", repository.findAll());
		return "bookstore";
	}
	
    @RequestMapping(value = "/addbook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    } 
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:bookstore";
    }   
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../bookstore";
	}
	
	@GetMapping(value = "/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		return "editbook";
	}

}
