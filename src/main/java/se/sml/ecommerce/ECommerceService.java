package se.sml.ecommerce;

import java.util.List;

import se.sml.ecommerce.model.Product;
import se.sml.ecommerce.repository.ProductRepository;

public class ECommerceService {
	private ProductRepository productRepository;

	public ECommerceService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// create one or more products
	public ECommerceService addProduct(Product product) {
		productRepository.create(product);
		return this;
	}
	
	// get a product by product id
	public Product getProductById (Long id) {
		return productRepository.getById(id);
	}
	
	// get a product by product name
	public Product getProductByName (String name) {
		return productRepository.getByName(name);
	}

	// get all product
	public List<Product> getAllProduct() {
		return productRepository.getAll();
	}

	// update a product
	public void updateProduct(Product product){
		productRepository.update(product);
	}
		
	// update product status
	public void setProductStatus(Product product){
		productRepository.update(product);
	}
		
}
