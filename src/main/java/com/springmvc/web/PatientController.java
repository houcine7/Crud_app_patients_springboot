package com.springmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.PatientRepository;
import com.springmvc.entities.Patient;

import jakarta.validation.Valid;

@Controller
public class PatientController {

	@Autowired
	private PatientRepository pR;

	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}

	@GetMapping(path = "/patients")
	public String patients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {

		Page<Patient> patientPage = pR.findByNameContains(keyword, PageRequest.of(page, size));
		model.addAttribute("patientsList", patientPage.getContent());
		model.addAttribute("pagesNumber", new int[patientPage.getTotalPages()]);
		model.addAttribute("activePage", page);
		model.addAttribute("keyword", keyword);
		return "patients";
	}

	@GetMapping(path = "deletPatient")
	public String delete(@RequestParam(name = "id") Long id, @RequestParam(name = "activePage") int page,
			@RequestParam(name = "keyword") String keyword) {
		pR.deleteById(id);
		return "redirect:/patients?page=" + page + "&keyword=" + keyword;
	}

	@GetMapping(path = "addPatient")
	public String addPatient(Model m) {
		m.addAttribute("patient", new Patient());
		return "addPatient";

	}

	@PostMapping("/savePatient")
	public String savePatient(@Valid Patient p ,BindingResult br) {
		if(br.hasErrors()) {
			System.out.println("error");
			return "addPatient";
		}
		System.out.println(p.toString());
		pR.save(p);
		return "addPatient";	
	}
	
	@GetMapping(path="editPatient")
	public String editPatient(Model m, @RequestParam Long id) {
		Patient p= pR.findById(id).get() ;
		m.addAttribute("patient", p) ;
		return "addPatient";	
	}
}
