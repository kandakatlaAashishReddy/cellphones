package aashish.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aashish.model.Product;
import aashish.model.Supplier;
import aashish.model.XMAP_Product_Supplier;
import aashish.service.ProductServiceInt;
import aashish.service.SupplierServiceInt;
import aashish.service.XpsServiceInt;

@Controller
public class XpsController {
	@Autowired
	private XpsServiceInt xpsService;
	
	@Autowired
	private ProductServiceInt productService;
	
	@Autowired
	private SupplierServiceInt supplierService;
	

	@RequestMapping("/reqDisplayXps")
	public String displaySuppliers(Model m,HttpSession hsession){
		List<XMAP_Product_Supplier> data = xpsService.getAllXps();
		m.addAttribute("xpsdata", data);
		return "displayXps";
	}
	
	@RequestMapping("/reqAddProdSuppForm")
	public String addSupplierForm(Model m,HttpSession hsession){	
		List<Product> productData = productService.getProducts();
		List<Supplier> supplierData = supplierService.getSupplier();
		m.addAttribute("products", productData);
		m.addAttribute("suppliers", supplierData);
		m.addAttribute("prodsuppObject", new XMAP_Product_Supplier());
		return "addProdSupp";
	}
	
	@RequestMapping("/reqAddProdSuppDataToDb")
	public String addProdSuppToDb(@ModelAttribute("prodsuppObject")XMAP_Product_Supplier xps,Model m,HttpSession hsession){
		xpsService.addxps(xps);
		String xpsmessage="XPS Record added successfully...";
		m.addAttribute("xpsmessage", xpsmessage);
		List<XMAP_Product_Supplier> data = xpsService.getAllXps();
		m.addAttribute("xpsdata", data);
		return "displayXps";
	}
	
	@RequestMapping("/reqDeleteXps")
	public String deleteXps(@RequestParam("psid")String productSupplierid,Model m,HttpSession hsession){
		xpsService.deleteXps(productSupplierid);	
		String xpsmessage="XPS Record deleted successfully...";
		m.addAttribute("xpsmessage", xpsmessage);
		List<XMAP_Product_Supplier> data = xpsService.getAllXps();
		m.addAttribute("xpsdata", data);
		return "displayXps";
	
}
	@RequestMapping("/reqEditXpsPage")
	public String editXPSPage(@RequestParam("psid")String psid,Model m){
		XMAP_Product_Supplier xps = xpsService.getXpsById(psid);	
		String pname  = productService.getProductByID(xps.getProductid()).getProductname();
		String supname = supplierService.getSupplierByID(xps.getSupplierid()).getSuppliername();
		
		m.addAttribute("xps", xps);	
		m.addAttribute("pname", pname);	
		m.addAttribute("supname", supname);	
		
		return "editXps";
	}
	
	@RequestMapping("/reqEditXpsToDB")
	public String editXPStoDB(@ModelAttribute("prodsuppObject")XMAP_Product_Supplier xps){
		xpsService.editXps(xps);			
		return "redirect:/reqDisplayXps";
	}

}
