package com.project.algocomparator.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.algocomparator.models.dtos.ResponseDTO;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ComparatorExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<ResponseDTO> handleInvalidComparisonRequestException(final InvalidRequestException ex){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(HttpStatus.PRECONDITION_FAILED, ex.getMessage()), HttpStatus.PRECONDITION_FAILED);
	}
}
