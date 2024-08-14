package com.project.algocomparator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.algocomparator.exception.InvalidRequestException;
import com.project.algocomparator.models.dtos.ComparisonRequestDTO;
import com.project.algocomparator.models.dtos.ResponseDTO;
import com.project.algocomparator.services.ComparisonRequestService;

@RestController
public class ComparisonRequestController {
	
	@Autowired
	private ComparisonRequestService comparisonRequestService;
	
	@PostMapping(value = "/compareAlgorithms", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> compareAlgorithms(@RequestBody ComparisonRequestDTO comparisonDTO) throws InvalidRequestException{
		comparisonRequestService.compareAlgorithms(comparisonDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(HttpStatus.OK, "Request Accepted"), HttpStatus.OK);
	}
}
