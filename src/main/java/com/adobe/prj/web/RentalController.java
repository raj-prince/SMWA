package com.adobe.prj.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Rental;
import com.adobe.prj.service.RentalService;

@Controller
public class RentalController {
	
	@Autowired
	private RentalService rentalService;
	
	@ModelAttribute("customers")
	public List<Customer> customers() {
		return rentalService.getCustomers();
	}
	
	@RequestMapping("rentalForm.do")
	public String getRentalForm(Model model) {
		model.addAttribute("rental", new Rental());
		return "rentalForm.jsp";
	}
	
	@RequestMapping("rent.do") 
	public String rent(@ModelAttribute("rental") Rental rental, Model m) {
		rentalService.rental(rental);
		m.addAttribute("msg", "Rental order placed!!!");
		return "index.jsp";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
