package se.sml.ecommerce.repository;

import java.util.List;

import se.sml.ecommerce.model.Product;

public interface CrudRepository <T>
{
	void create (T object);
	
	T getById(Long id);
	
	T getByName(String Name);
	
	List<T> getAll();
	
	void update(T object);	
}
