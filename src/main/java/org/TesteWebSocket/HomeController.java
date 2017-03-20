package org.TesteWebSocket;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class HomeController {
	
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		return modelAndView;
	}
	 
}