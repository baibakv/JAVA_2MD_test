package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;



@Service
public class productCRUDServiceImpl implements IProductCRUDService{
	
	@Autowired
	private IProductRepo prodRepo;
	

	@Override
	public void createProduct(String title, String description, float price, int quantity) throws Exception {
		if(description == null || !title.matches("[A-Z]{1}[a-z]{2,15}") ||
				description.matches("[A-Za-z ;:]{3,30}") || price < 0 || price > 1000 || quantity < 0 || quantity > 100) {
			throw new Exception ("Incorrect imput params");
		}
		if(prodRepo.existsByTitleAndDescriptionAndPrice(title, description, price)) {
			Product productExists = prodRepo.findByTitleAndDescriptionAndPrice(title, description, price);
			
			int newQuantity = productExists.getQuantity() + quantity;
			productExists.setQuantity(newQuantity);
			prodRepo.save(productExists);
 		}
		
		else {
			Product newProduct = new Product(title, description, price, quantity);
			prodRepo.save(newProduct);
		}
	}
	

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(prodRepo.count() == 0 ) {
			throw new Exception("Product table is empty!");
		}
		ArrayList<Product> result = (ArrayList<Product>) prodRepo.findAll();
		return result;
	}
	

	@Override
	public Product retrieveById(long id) throws Exception {
		if(id <= 0) {
			throw new Exception("Product doesnt exist!");
		}
		if(prodRepo.existsById(id)) {
			throw new Exception("Product with this id doesnt exist!");
		}
		
		Product retrievedproduct = prodRepo.findById(id).get();
		return retrievedproduct;
	}
	

	@Override
	public void updateProductById(long id, String description, float price, int quantity) throws Exception {
		Product productForUpdating = retrieveById(id);
		
		if(description == null || description.matches("[A-Za-z ;:]{3,30}") || price < 0 || price > 1000 || quantity < 0 || quantity > 100) {
			throw new Exception ("Incorrect imput params");
		}
		if(productForUpdating.getDescription().equals(description)){
			productForUpdating.setDescription(description);
		}
		if(productForUpdating.getPrice() != price){
			productForUpdating.setPrice(price);
		}
		if(productForUpdating.getQuantity() != quantity){
			productForUpdating.setQuantity(quantity);
		}
		prodRepo.save(productForUpdating);
	}
	

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
