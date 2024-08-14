package com.project.algocomparator.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.algocomparator.configurations.CommonMappings;
import com.project.algocomparator.models.dtos.ExecutionDetailsDTO;

@Service
public class ComparisonResponseService {
	public Map<String, Long> getResponse(String algoId){
		CommonMappings.LOCK.lock();
		Map<String, Long> response = CommonMappings.ALGORITHM_EXECUTION_TIME_CACHE.getExecutionTimeMap().get(algoId);
		CommonMappings.LOCK.unlock();
		
		return response;
	}
	
	public ExecutionDetailsDTO getAllResponses(){
		CommonMappings.LOCK.lock();
		ExecutionDetailsDTO response = CommonMappings.ALGORITHM_EXECUTION_TIME_CACHE;
		CommonMappings.LOCK.unlock();
		
		return response;
	}
}
