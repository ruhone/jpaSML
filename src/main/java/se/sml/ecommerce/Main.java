package se.sml.ecommerce;

import java.util.ArrayList;
import java.util.List;

import se.sml.ecommerce.model.Product;
import se.sml.ecommerce.repository.ProductRepository;
import se.sml.ecommerce.repository.storage.jpaProductRepository;

public class Main {

	
	public static void main(String[] args) {
//		Product product1 = new Product("Milk", 11L, "In Stock");
//		Product product2 = new Product("Cola", 14L, "Out of Stock");
//		Product product3 = new Product("Juice", 17L, "In Stock");
//		Product product4 = new Product("Pepsi", 7L, "In Stock");
//		Product product5 = new Product("Ramlösa", 8L, "Out of Stock");
		
		ProductRepository productRepository = new jpaProductRepository();	
		ECommerceService eService = new ECommerceService(productRepository);
		
		// create one or more products and save it in the Database
//		eService.addProduct(product1).addProduct(product2).addProduct(product3);
//		eService.addProduct(product5);
				
//		// get a product by product Id
		System.out.println(eService.getProductById(3L));
	
//		// get a product by product Name. Fetches a single product because each product name is unique.
		System.out.println(eService.getProductByName("Pepsi"));
		
//		// get all products
		List<Product> list = new ArrayList<>();
		list = eService.getAllProduct();
		list.forEach(prod -> System.out.println(prod)); 

		// Update a product specifying product name, what values and which properties to update		
		String updateProperty = "updatePrice";
		eService.updateProduct("Cola", 12L, updateProperty);		
		//eService.updateProduct("Pepsi", "In Stock", updateProperty);
		
	}
}
