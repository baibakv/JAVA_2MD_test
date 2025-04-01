package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductCRUDService {
	//CRUD
	//create
	public abstract void createProduct(String title, String description, float price, int quantity) throws Exception;
	
	
	//retrieve all
	public abstract ArrayList<Product> retrieveAll() throws Exception;
	
	
	//retrieve by Id
	public abstract Product retrieveById(int id) throws Exception;
	
	
	//update
	public abstract void updateProductById(int id, String description, float price, int quantity) throws Exception;
	
	
	//delete
	public abstract void deleteById(int id) throws Exception;
	
	
}
