package com.dojosninjas.moneem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojosninjas.moneem.models.Dojo;
import com.dojosninjas.moneem.models.Ninja;
import com.dojosninjas.moneem.services.DojoService;
import com.dojosninjas.moneem.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

	// inject NinjaService in our NinjaController
	@Autowired
	private NinjaService ninjaService;

	// inject DojoService in our NinjaController
	@Autowired
	private DojoService dojoService;

	// Display route : redirect to ninjasPages.jsp page
	@GetMapping("/pages")
	public String index() {
		return "redirect:/pages/1";
	}

	// Display route :show all ninjas and dojos using pages : ninjasPages.jsp
	@GetMapping("/pages/{numberOfPage}")
	public String allNinjasPerPage(@PathVariable("numberOfPage") int numberOfPage, Model model) {
		// we have to subtract 1 because the Pages iterable is 0 indexed. This is for
		// our links to be able to show from 1...pageMax, instead of 0...pageMax
		Page<Ninja> ninjas = this.ninjaService.getNinjasPerPage(numberOfPage - 1);
		int totalpages = ninjas.getTotalPages();
		// total number of pages that we have
		model.addAttribute("totalpages", totalpages);
		model.addAttribute("ninjas", ninjas);
		return "ninjasPages.jsp";
	}

	// route for Ninja form (send empty ninja object to the form)
	@GetMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model modelView) {

		// send all dojos to the Ninjaform using dojoService
		List<Dojo> dojos = dojoService.allDojos();
		modelView.addAttribute("dojos", dojos);
		return "NinjaForm.jsp";
	}

	// route to submit the form
	@PostMapping("/create/ninja")
	public String createDojo(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model modelView) {
		if (result.hasErrors()) {
			// if we have errors validation we are showing to user the errors and send all
			// the dojos to the form again
			modelView.addAttribute("dojos", dojoService.allDojos());
			return "NinjaForm.jsp";
		}
		ninjaService.addNinja(ninja);
		return "redirect:/dojos";
	}

}
