package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;

@Controller
public class UserController {
	// GET: /
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	// Add the following Controller Actions

	// GET: /register
	// Return the empty registration view
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String displayRegister(Model model) {
		if(!model.containsAttribute("registration")) {
			model.addAttribute("registration", new Registration());
		}
		return "register";
	}

	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
	@RequestMapping(path="/doRegister", method=RequestMethod.POST)
	public String doRegister(@Valid@ModelAttribute("registration") Registration registration, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "register";
		}
		attr.addFlashAttribute("confirmationAction", "registered");
		return "redirect:/confirmation";
	}

	// GET: /login
	// Return the empty login view
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLogin(Model model) {
		if(!model.containsAttribute("login")) {
			model.addAttribute("login", new Login());
		}
		return "login";
	}

	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)
	@RequestMapping(path="/doLogin", method=RequestMethod.POST)
	public String doLogin(@Valid@ModelAttribute("login") Login login, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "login";
		}
		attr.addFlashAttribute("confirmationAction", "logged in");
		return "redirect:/confirmation";
	}

	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String getConfirmationScreen() {
		return "confirmation";
	}
	
}
