package se.sml.ecommerce.repository.storage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import se.sml.ecommerce.model.Product;
import se.sml.ecommerce.repository.ProductRepository;
import se.sml.ecommerce.repository.checkedexception.RepositoryException;

public class jpaProductRepository implements ProductRepository {
	public static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	// Add one or more product
	@Override
	public void create(Product product) throws RepositoryException{
		try {
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(product);
			manager.getTransaction().commit();
			manager.close();
		}
		catch (NoResultException e) {
			throw new RepositoryException("Can't add this product.");
		}
	}

	// Get product using product ID
	@Override
	public Product getById(Long id) throws RepositoryException {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Product product = manager.find(Product.class, id);
		manager.close();
		return product;
	}

	// Get product by name
	@Override
	public Product getByName(String productName) throws RepositoryException{
		try {
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
		
			Product product = manager.createNamedQuery("Product.GetByProductName", Product.class)
													.setParameter("productName", productName).getSingleResult();
			manager.close();
			return product;
		}
		catch (NoResultException e) {
			throw new RepositoryException("No product such found for this name");
		}
	}
	
	// Get all products in the database
	@Override
	public List<Product> getAll() throws RepositoryException {
		EntityManager manager = factory.createEntityManager();
		List<Product> products = manager.createNamedQuery("Product.GetAll", Product.class).getResultList();
		manager.close();
		return products;
	}

	// Update a product specifying product name, what values and which properties to update
	@Override
	public void update(String name, Object value, String updateProperty) throws RepositoryException
	{
		try
		{
			EntityManager manager = factory.createEntityManager();
			Product product = getByName(name);

			switch (updateProperty)
			{
			case ("updatePrice"):
				Long price = (Long) value;
				product.setPrice(price);
				break;
			case ("updateStatus"):
				String status = (String) value;
				product.setStatus(status);
				break;
			}

			manager.getTransaction().begin();
			product = manager.merge(product);
			manager.getTransaction().commit();
			manager.close();
		}
		catch (NoResultException e)
		{
			throw new RepositoryException("Can't update a product that doesn't exist");
		}
	}
}
