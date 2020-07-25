package org.exception;


public class ServiceException extends Exception{
	

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new service exception.
	 *
	 * @param message the message
	 */
	public ServiceException(String message){
		super(message);
		
	}
	
	/**
	 * Instantiates a new service exception.
	 */
	public ServiceException(){
		super();
		
	}
}
