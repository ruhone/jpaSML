package se.sml.ecommerce.uncheckedexception;

public class ECommerceServiceException extends RuntimeException
{
	private static final long serialVersionUID = -7825865829438663596L;
	
	public ECommerceServiceException(String message) {
		super(message);
	}

	public ECommerceServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
