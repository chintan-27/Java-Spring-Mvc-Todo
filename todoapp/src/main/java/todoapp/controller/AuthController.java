package todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import todoapp.models.User;
import todoapp.services.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	 
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public RedirectView handleLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model m) {
		Integer id = this.authService.login(email, password);
		RedirectView redirectView = new RedirectView();
		if(id == 0) {
			m.addAttribute("message", "Invalid Credentials");
			redirectView.setUrl("/todoapp/auth/login");
			return redirectView;
		}else {
			redirectView.setUrl("/todoapp/tasks?user_id=" + id.toString());
			return redirectView;
		}
		
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String showRegister() {
		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public RedirectView handleRegister(@ModelAttribute("user") User user, Model model) {
		this.authService.register(user);
		RedirectView redirectView = new RedirectView("/todoapp/auth/login/");
		return redirectView;
	}
}
