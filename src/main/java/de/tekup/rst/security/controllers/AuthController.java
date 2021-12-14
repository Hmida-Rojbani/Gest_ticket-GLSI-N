package de.tekup.rst.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.rst.security.entities.User;
import de.tekup.rst.security.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Controller
@Slf4j
public class AuthController {
	
	private UserService userService;
	
	@GetMapping("/register")
	public String getRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "auth/signup";
	}
	
	@PostMapping("/register")
	public String postRegisterForm(@ModelAttribute("user") User user) {
		log.info(user.toString());
		userService.registerUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "auth/signin";
	}

}
