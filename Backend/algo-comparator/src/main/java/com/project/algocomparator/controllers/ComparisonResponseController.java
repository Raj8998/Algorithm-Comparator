package com.project.algocomparator.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.algocomparator.models.dtos.ExecutionDetailsDTO;
import com.project.algocomparator.services.ComparisonResponseService;

@RestController
public class ComparisonResponseController {
	@Autowired
	private ComparisonResponseService responseService;

	@GetMapping(value = "/getResponse")
	public ResponseEntity<Map<String, Long>> getResponse(@RequestParam(name = "algoId") String algoId) {
		return new ResponseEntity<Map<String, Long>>(responseService.getResponse(algoId), HttpStatus.OK);
	}
	
	@GetMapping(value = "getAllResponses")
	public ResponseEntity<ExecutionDetailsDTO> getAllResponses(){
		return new ResponseEntity<ExecutionDetailsDTO>(responseService.getAllResponses(), HttpStatus.OK);
	}
}
