package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerHelloWorld {
	String message = "Welcome to Spring MVC!";
	@RequestMapping ("/showMessage")
	public ModelAndView showMessage (){
		System.out.println ("in controller");
		// ModelAndView mv = new ModelAndView ("hello", "message", message);
		ModelAndView mv = new ModelAndView ("showMessage");
		mv.addObject ("message", message);
		return mv;
	}
}
