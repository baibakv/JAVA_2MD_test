package lv.venta.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	//1. mainigie
	@Setter(value = AccessLevel.NONE)
	private long id;
	
	private String title;
	private String description;
	private float price;
	private int quantity;
	//2. getters - no lombok
	//3. setters - no lombok
	//4. bezarg - no lombok
	//5. arg
	public Product(String inputTitle, String inputDescription, float inputPrice, int inputQuantity) {
		setTitle(inputTitle);
		setDescription(inputDescription);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
	}
	//6. tostring - no lombok
	//7. citas
}
