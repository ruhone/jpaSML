package se.sml.ecommerce.repository.storage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.sml.ecommerce.model.Product;
import se.sml.ecommerce.repository.ProductRepository;

public class jpaProductRepository implements ProductRepository
{


public static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	@Override
	public void create(Product product)
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(product);
		
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Product getById(Long id)
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.close();
		
		return manager.find(Product.class, id);
		
	}

	@Override
	public List<Product> getAll()
	{
		EntityManager manager = factory.createEntityManager();
		
		List<Product> products = manager.createNamedQuery("Product.GetAll", Product.class).getResultList();
		
		manager.close();
		return products;
	}

	@Override
	public Product getByName(String productName)
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Product product = manager.createNamedQuery("Product.GetByProductName", Product.class)
													.setParameter("productName", productName).getSingleResult();
		manager.close();
		return product;
	}

	@Override
	public void update (Product product)
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();	
		
		manager.merge(product);
	
		manager.getTransaction().commit();
		manager.close();
	}
	
	

}
