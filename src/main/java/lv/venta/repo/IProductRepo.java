package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;

//Product- uz kutu tabulu sis strada
//long - tabulas primary key tips(ar lielo burtu)

public interface IProductRepo extends CrudRepository<Product, Long>{
	
}
