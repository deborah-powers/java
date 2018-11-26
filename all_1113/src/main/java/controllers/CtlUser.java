package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entities.User;
import services.ServiceUser;

@Controller
public class CtlUser {
	@Autowired
	private ServiceUser su;

	@RequestMapping (value = "/", method = RequestMethod.GET)
	public ModelAndView pageList (){
		System.out.println ("ctl pageList");
		List<User> userList = su.findAll ();
		ModelAndView mv = new ModelAndView ("list");
		mv.addObject ("list", userList);
		return mv;
	}
	@ModelAttribute ("user")
	// cf src/main/webapp/WEB-INF/view/form.jsp
	public User inputUser (){
		return new User ();
	}
}
