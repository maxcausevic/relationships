package com.mcausevic.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcausevic.relationships.models.DriverService;
import com.mcausevic.relationships.models.License;
import com.mcausevic.relationships.models.Person;

@Controller
public class DriverController {
	private DriverService driverService;
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/persons/new")
	public String newPerson() {
		return "NewPerson.jsp";
	}
	@RequestMapping("/licenses/new")
	public String newLicense(Model model) {
		List<Person> Person = driverService.allpersons();
	    model.addAttribute("persons", Person);
	    model.addAttribute("license", new License());
	    
		return "NewLicense.jsp";
	}
	
	@RequestMapping(value="/createPerson",method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "NewPerson.jsp";
		}else
			driverService.createPerson(person);
			
		return "redirect:/";
		
	}	
	@RequestMapping(value="/createLicense",method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result,@RequestParam("person") String id, Model model) {
		
		if(result.hasErrors()) {
			System.out.println(result.getFieldError());
			return "NewLicense.jsp";
			
		}else {
			Long personId = Long.parseLong(id);
			Person person = driverService.findPerson(personId);
			
			String number = "0000000";
			license.setPerson(person);
			System.out.println("test");
			License license1 = driverService.createLicense(license);
			license1.setNumber(number + String.valueOf(license1.getId()));
			driverService.createLicense(license1);
		}
		return "redirect:/";
		
	}	
	@RequestMapping("/person/{id}")
		public String show(Model model, @PathVariable("id") Long id) {
			Person person = driverService.findPerson(id);
			License license = driverService.findLicense(id);
			model.addAttribute("person", person);
			model.addAttribute("license", license);
			return "show.jsp";
	}
}
