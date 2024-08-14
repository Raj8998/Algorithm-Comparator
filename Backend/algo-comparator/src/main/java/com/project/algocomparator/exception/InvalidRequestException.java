package com.project.algocomparator.exception;

public class InvalidRequestException extends Exception{
	
	private static final long serialVersionUID = -4278081544780061675L;
	
	public InvalidRequestException(String error) {
		super(error);
	}
}
