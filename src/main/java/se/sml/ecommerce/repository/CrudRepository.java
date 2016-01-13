package se.sml.ecommerce.repository;

import java.util.List;

import se.sml.ecommerce.repository.checkedexception.RepositoryException;

public interface CrudRepository <T>
{
	void create (T object) throws RepositoryException;	
	
	T getById(Long id) throws RepositoryException;
	
	T getByName(String Name) throws RepositoryException;
	
	List<T> getAll() throws RepositoryException;
	
//	void update(T object) throws RepositoryException;
	
	void update(String name, Object value, String updateProperty) throws RepositoryException;
}
