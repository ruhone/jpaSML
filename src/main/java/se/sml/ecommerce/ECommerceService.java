package se.sml.ecommerce;

import java.util.List;

import se.sml.ecommerce.model.Product;
import se.sml.ecommerce.repository.ProductRepository;
import se.sml.ecommerce.repository.checkedexception.RepositoryException;
import se.sml.ecommerce.uncheckedexception.ECommerceServiceException;

public class ECommerceService {
	private ProductRepository productRepository;

	public ECommerceService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// create one or more products //create
	public ECommerceService createProduct(Product product){
		try {
			productRepository.create(product);
		}
		catch (RepositoryException ex) {
			throw new ECommerceServiceException("The product name '"+ product.getProductName()+"' already exists. Please choose another name");
		}
		
		return this;
	}
	
	// get a product by product id
	public Product getProductById (Long id) {		
		try {
			if (productRepository.getById(id) == null) {
				throw new ECommerceServiceException("The product with ID: " + id + " is not found in storage");
			}
			else {
				return productRepository.getById(id);
			}
		}	
		catch(RepositoryException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// get a product by product name
	public Product getProductByName (String name) throws ECommerceServiceException {	
		Product product;
		try {
			product = productRepository.getByName(name);
		}	
		catch(RepositoryException e) {
			throw new ECommerceServiceException("Product with the name '"+ name + "' not found in storage");
		}		
		return product;
	}

	// get all product
	public List<Product> getAllProduct() {
		try {
			return productRepository.getAll();
		}
		catch(RepositoryException e) {
			throw new ECommerceServiceException("No product is available at the storage", e);
		}
	}
	
	// Update a product specifying product name, what values and which properties to update
	public void updateProduct(String prodName, Object value, String updateProperty){
			try {
				productRepository.update(prodName, value, updateProperty);
			}
			catch (RepositoryException e) {
				throw new ECommerceServiceException("Can't update the product, Please try again later");
			}
	}
}
