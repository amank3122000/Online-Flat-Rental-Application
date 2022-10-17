package com.cg.onlineflatrental.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineflatrental.utility.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	Environment environment;
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value = FlatBookingNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleFlatBookingNotFoundException(FlatBookingNotFoundException fbnf)
	{
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(fbnf.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = FlatNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleFlatNotFoundException(FlatNotFoundException fnf){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(fnf.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = LandlordNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleLandlordNotFoundException(LandlordNotFoundException lnf){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(lnf.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(value = TenantNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleTenantNotFoundException(TenantNotFoundException tnf){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(tnf.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUserNotFoundException(UserNotFoundException unf)
	{   ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(unf.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<ErrorInfo> handleValidationException(ValidationException ve) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(ve.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
}
