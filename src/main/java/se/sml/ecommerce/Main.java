package se.sml.ecommerce;

import java.util.ArrayList;
import java.util.List;

import se.sml.ecommerce.model.Product;
import se.sml.ecommerce.repository.ProductRepository;
import se.sml.ecommerce.repository.storage.jpaProductRepository;

public class Main {

	
	public static void main(String[] args) {
		Product product1 = new Product("AA", 12L, "In Stock");
		Product product2 = new Product("BB", 12L, "Out of Stock");
		Product product3 = new Product("CC", 12L, "In Stock");
		
		ProductRepository productRepository = new jpaProductRepository();	
		ECommerceService eService = new ECommerceService(productRepository);
		
		// create one or more products and save it in the Database
		eService.addProduct(product1).addProduct(product2).addProduct(product3);
		
		// get a product by product Id
		System.out.println(eService.getProductById(2L));

		// get a product by product Name. Fetches a single product because each product name is unique.
		System.out.println(eService.getProductByName("AA"));
		
		// get all products
		List<Product> list = new ArrayList<>();
		list = eService.getAllProduct();
		list.forEach(prod -> System.out.println(prod)); 

		// update a product
		product2.setPrice(22L);
		eService.updateProduct(product2);
	
		// update product status
		product1.setStatus("Out of Stock");
		eService.setProductStatus(product1);
	}
}
