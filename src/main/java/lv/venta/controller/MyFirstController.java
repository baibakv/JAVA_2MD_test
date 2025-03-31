package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Product;

@Controller
public class MyFirstController {
	
	private Random rand = new Random();
	
	
	@GetMapping("/simple") //localhost:8080/simple
	public String myFirstGetController() {
		System.out.println("Pirmais kotrolieris nostradaja!");
		return "simple-page"; //paradit simple-page.htm
	}
	
	
	
	@GetMapping("/getdata")//localhost:8080/getdata
	public String getControllerSendData(Model model) {
		System.out.println("Send data kotrolieris nostradaja!");
		String data =  "Baiba -> " + rand.nextInt(0, 101);
		model.addAttribute("package", data);
		return "show-data-page";
	}
	
	
	
	@GetMapping("/getproduct")//localhost:8080/getproduct
	public String getControllerSendProduct(Model model) {
		Product newProduct = new Product ("Abols", "Garsigs", 0.99f, 4); 
		model.addAttribute("package", newProduct);
		return"show-one-product"; //paradis vienu produktu
	}
	
	
	
	@GetMapping("/getmultipleproducts")//localhost:8080/getmultiplsproducts
	public String getControllerSendMultipleProducts(Model model) {
		ArrayList<Product>newProducts = new ArrayList<>(Arrays.asList(
				new Product ("Abols", "Garsigs", 0.99f, 4),
				new Product ("Gurķis", "Garš", 0.57f, 5),
				new Product ("Tomats", "Suligs", 1.79f, 1)
				));
		model.addAttribute("package", newProducts);
		return"show-multiple-products";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
