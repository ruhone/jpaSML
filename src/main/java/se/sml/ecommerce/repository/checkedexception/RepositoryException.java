package se.sml.ecommerce.repository.checkedexception;

public class RepositoryException extends Exception {
	private static final long serialVersionUID = -7379090187333389590L;

	public RepositoryException() {
		super();
	}
	
	public RepositoryException(String message) {
		super(message);
	}
	
	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
