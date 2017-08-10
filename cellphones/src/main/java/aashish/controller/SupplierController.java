package aashish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aashish.model.Supplier;
import aashish.service.SupplierServiceInt;

@Controller
public class SupplierController {
	@Autowired
	private SupplierServiceInt supplierService;

	@RequestMapping("/reqAddSupplierForm")
	public String addProdform(Model m) {
		m.addAttribute("supplierObject", new Supplier());
		return "addSupplier";
	}

	@RequestMapping("/reqsupplierform")
	public String displaysignupdata(@ModelAttribute("supplierObject") Supplier sup, Model m) {
		sup.setIssupplieravailable(true);
		supplierService.addSupplier(sup);
		return "adminHomePage";
	}

	@RequestMapping("/reqDisplaySuppliers")
	public String displaySupplierAdmin(Model m) {
		List<Supplier> allsupplier = supplierService.getSupplier();
		System.out.println(allsupplier);
		System.out.println(allsupplier.get(0).getSupplierid());
		m.addAttribute("allsupplier", allsupplier);
		return "displaySupplierAdmin";
	}

	@RequestMapping("/reqdeletesupplierAdmin")
	public String deletesupplier(@RequestParam("sp") String sp) {
		supplierService.deleteSupplier(sp);
		return "redirect:reqDisplaySuppliers";
	}

	@RequestMapping("/reqeditsupplierpageAdmin")
	public String editsupplier(@RequestParam("sp") String sp, Model m) {
		Supplier sup = supplierService.getSupplierByID(sp);
		m.addAttribute("supplier", sup);
		return "supplierEditAdmin";

	}

	@RequestMapping("/reqSendUpdatedSupplierToDB")
	public String updateSupplierToDB(@ModelAttribute("supplierObject") Supplier sup) {
		supplierService.updateSupplier(sup);
		return "redirect:reqDisplaySuppliers";
	}

}
