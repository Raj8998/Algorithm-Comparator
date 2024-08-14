package com.project.algocomparator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.algocomparator.models.dtos.AlgorithmDTO;
import com.project.algocomparator.services.AlgorithmDetailsService;

@RestController
public class AlgorithmDetailsController {
	
	@Autowired
	private AlgorithmDetailsService algorithmDetailsService;
	
	@GetMapping(path = "/getAlgorithmDetails")
	public List<AlgorithmDTO> getAlgorithmDetails() {
		return algorithmDetailsService.getAlgorithmDetails();
	}
}
