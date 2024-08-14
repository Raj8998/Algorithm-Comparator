package com.project.algocomparator.models.dtos;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExecutionDetailsDTO {
	
	private int testCases;
	private Map<String, Map<String, Long>> executionTimeMap = new ConcurrentHashMap<String, Map<String,Long>>();
	
	public ExecutionDetailsDTO(int testCases, Map<String, Map<String, Long>> executionTimeMap) {
		super();
		this.testCases = testCases;
		this.executionTimeMap = executionTimeMap;
	}

	public int getTestCases() {
		return testCases;
	}

	public void setTestCases(int testCases) {
		this.testCases = testCases;
	}

	public Map<String, Map<String, Long>> getExecutionTimeMap() {
		return executionTimeMap;
	}

	public void setExecutionTimeMap(Map<String, Map<String, Long>> executionTimeMap) {
		this.executionTimeMap = executionTimeMap;
	}

	@Override
	public String toString() {
		return "ExecutionDetailsDTO [testCases=" + testCases + ", executionTimeMap=" + executionTimeMap + "]";
	}
}
