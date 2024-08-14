package com.project.algocomparator.models.dtos;

import java.util.List;

public class ComparisonRequestDTO {
	private List<String> algorithmNameIDs;
	private String dataSetNameID;
	
	public ComparisonRequestDTO(List<String> algorithmNameIDs, String dataSetNameID) {
		super();
		this.algorithmNameIDs = algorithmNameIDs;
		this.dataSetNameID = dataSetNameID;
	}

	public List<String> getAlgorithmNameIDs() {
		return algorithmNameIDs;
	}

	public void setAlgorithmNameIDs(List<String> algorithmNameIDs) {
		this.algorithmNameIDs = algorithmNameIDs;
	}

	public String getDataSetNameID() {
		return dataSetNameID;
	}

	public void setDataSetNameID(String dataSetNameID) {
		this.dataSetNameID = dataSetNameID;
	}

	@Override
	public String toString() {
		return "ComparisonRequestDTO [algorithmNameIDs=" + algorithmNameIDs + ", dataSetNameID=" + dataSetNameID + "]";
	}
}
