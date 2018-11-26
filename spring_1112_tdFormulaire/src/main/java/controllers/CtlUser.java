package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.User;

@Controller
public class CtlUser {
	@RequestMapping ("/")
	public ModelAndView lauchForm (){
		System.out.println ("in controller");
		// ModelAndView mv = new ModelAndView ("hello", "message", message);
		ModelAndView mv = new ModelAndView ("form");
		return mv;
	}
	@RequestMapping ("/sendData")
	// cf src/main/webapp/WEB-INF/view/form.jsp
	// public ModelAndView launchResult (User user)
	public ModelAndView launchResult (@ModelAttribute User user){
		System.out.println (user);
		ModelAndView mv = new ModelAndView ("result");
		mv.addObject ("user", user);
		return mv;
	}
	@ModelAttribute ("user")
	// cf src/main/webapp/WEB-INF/view/form.jsp
	public User inputUser (){
		return new User ();
	}
}
