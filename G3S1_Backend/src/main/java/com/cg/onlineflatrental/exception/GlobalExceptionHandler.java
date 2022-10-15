package com.cg.onlineflatrental.exception;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = FlatBookingNotFoundException.class)
	public ResponseEntity<String> handleFlatBookingNotFoundException(FlatBookingNotFoundException fbnf)
	{
		return new ResponseEntity<String>("Flat booking not found. Please try again.",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = FlatNotFoundException.class)
	public ResponseEntity<String> handleFlatNotFoundException(FlatNotFoundException fnf){
		return new ResponseEntity<String>("Flat not found. Please try again.",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = LandlordNotFoundException.class)
	public ResponseEntity<String> handleLandlordNotFoundException(LandlordNotFoundException lnf){
		return new ResponseEntity<String>("Landlord Not found. Please try again.", HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(value = TenantNotFoundException.class)
	public ResponseEntity<String> handleTenantNotFoundException(TenantNotFoundException tnf){
		return new ResponseEntity<String>("Tenant not found. Please try again.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException unf)
	{
		return new ResponseEntity<String>("User not found. Please try again.",HttpStatus.NOT_FOUND);
	}
	
}
