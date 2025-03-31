package lv.venta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyFirstController {
	
	@GetMapping("/simple") //localhost8080/simple
	public String myFirstGetController() {
		System.out.println("Pirmais kotrolieris nostradaja!");
		return "simple-page"; //paradit simple-page.htm
	}
}
