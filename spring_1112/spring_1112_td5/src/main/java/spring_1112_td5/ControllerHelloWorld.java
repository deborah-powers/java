package spring_1112_td5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerHelloWorld {
	String message = "Welcome to Spring MVC!";
	@RequestMapping ("/hello")
	public ModelAndView showMessage (){
		System.out.println ("in controller");
		// ModelAndView mv = new ModelAndView ("hello", "message", message);
		ModelAndView mv = new ModelAndView ("hello");
		mv.addObject ("message", message);
		return mv;
	}
	@RequestMapping ("/hello2")
	// public ModelAndView showMessage2 (@RequestParam(value = "name", required = false, defaultValue = "World") String name){
	public ModelAndView showMessage2 (String name){
		System.out.println ("in controller");
		ModelAndView mv = new ModelAndView ("hello2");
		mv.addObject ("message", message);
		mv.addObject ("name", name);
		return mv;
	}
}
