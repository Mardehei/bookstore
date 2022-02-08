package hh22.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody // tämä lähtee kun tehtävää viedään eteenpäin ja tehdään html-template
public class BookController {

	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public String Books() {
		return "Books";
	}
}
